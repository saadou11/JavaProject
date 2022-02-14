package com.fsociety.jobs

import com.fsociety.utils.Utils.{codesReferentialColumns, englishColumns, renameColumns}
import org.apache.spark.sql.expressions.{Window, WindowSpec}
import org.apache.spark.sql.functions.{avg, col, count, desc, last, lead, length, lit, max, rank, row_number, trim, upper, when}
import org.apache.spark.sql.{DataFrame, RowFactory, SparkSession}
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

object BicycleJob extends App {

  import spark.implicits._

  lazy val spark: SparkSession = {
    SparkSession
      .builder()
      .master("local")
      .appName("spark bicycle data")
      .getOrCreate()
  }

  spark.conf.getAll.foreach(println)

  val window: WindowSpec = Window.partitionBy("city_name")

  val postalCodeReferential = spark.read
    .option("header", true)
    .option("sep", ";")
    .csv("src/main/resources/referential/insee_postal_code.csv")
    .transform(renameColumns(codesReferentialColumns))
    .select("insee_code", "city_name")
    .withColumn("city_name",
      when(col("city_name").startsWith("PARIS") && col("insee_code").startsWith("75"), lit("PARIS"))
        .otherwise(trim($"city_name"))
    )

  postalCodeReferential.show(100, false)

  val bicycle = spark.read
    .option("header", true)
    .option("sep", ";")
    .csv("src/main/resources/velib/real_time_velib_data.csv")
    .transform(renameColumns(englishColumns))
    .drop("insee_code")
    .withColumn("city_name", upper(trim(col("city_name"))))
    .withColumn("station_is_valid_capacity",
      when(col("station_capacity") === col("station_nb_free_borne") + col("total_free_bike"), lit(true))
        .otherwise(lit(false))
    )
    .join(postalCodeReferential, "city_name")

  //.withColumn("row_number", row_number() over window.orderBy(desc("station_capacity")))
  //.withColumn("max_in_window", last("row_number") over window)
  //.withColumn("station_average_capacity", avg("station_capacity") over window)

  bicycle.show(false)

  val outputColumns = bicycle.columns.sorted.map(col)
  bicycle.select(outputColumns: _*).show(false)

  /*
    bicycle.write.parquet("local_10_repartition")
    Thread.sleep(100000)

    val readDF = spark.read.parquet("local_5_repartition")
    Thread.sleep(100000)
    println(readDF.rdd.getNumPartitions)
    */
}

