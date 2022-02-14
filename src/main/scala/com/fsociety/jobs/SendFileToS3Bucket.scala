package com.fsociety.jobs

import com.amazonaws.auth.{AWSCredentials, AWSCredentialsProvider, AWSStaticCredentialsProvider, BasicAWSCredentials}
import com.amazonaws.services.s3.{AmazonS3Client, AmazonS3ClientBuilder}
import com.fsociety.utils.AWSUtils
import com.fsociety.utils.AWSUtils.*

import java.io.File

object SendFileToS3Bucket extends App {

  val fileToUpload = new File("src/main/resources/velib/real_time_velib_data.csv")
  s3Client.putObject("fsociety-bucket-data", "uploaded_20220104", fileToUpload)
}
