package com.fsociety.utils

import org.apache.spark.sql.DataFrame

object Utils {

  val englishColumns = Seq(
    "station_id",
    "station_name",
    "station_is_working",
    "station_capacity",
    "station_nb_free_borne",
    "total_free_bike",
    "total_mechanical_bike",
    "total_electric_bike",
    "station_with_payment",
    "station_bring_back_bike",
    "update_date",
    "station_geo_points",
    "city_name",
    "insee_code"
  )

  val codesReferentialColumns = Seq(
    "insee_code",
    "postal_code",
    "city_name",
    "department",
    "region",
    "status",
    "avg_alt",
    "area",
    "population",
    "city_geo_points",
    "geo_shape",
    "id_geo_fla",
    "city_code",
    "canton_code",
    "arran_code",
    "department_code",
    "region_code"
  )

  /**
   *
   * @param columns list of translated column names
   * @param df      implicit dataframe to be transformed
   * @return
   */
  def renameColumns(columns: Seq[String])(df: DataFrame): DataFrame = df.toDF(columns: _*)
  
}
