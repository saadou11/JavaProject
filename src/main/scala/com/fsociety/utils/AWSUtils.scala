package com.fsociety.utils

import com.amazonaws.auth.profile.ProfileCredentialsProvider
import com.amazonaws.auth.{AWSStaticCredentialsProvider, BasicAWSCredentials}
import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.{AmazonS3, AmazonS3ClientBuilder}
import com.amazonaws.services.secretsmanager.model.{AWSSecretsManagerException, GetSecretValueRequest, GetSecretValueResult}
import com.amazonaws.services.secretsmanager.{AWSSecretsManager, AWSSecretsManagerClient, AWSSecretsManagerClientBuilder}

object AWSUtils {

  //@todo hide credentials
  val AWS_ACCESS_KEY = ""
  val AWS_SECRET_KEY = ""

  /**
   *
   * @return
   */
  def getCredentials = new BasicAWSCredentials(AWS_ACCESS_KEY, AWS_SECRET_KEY)

  /**
   *
   * @return
   */
  def s3Client: AmazonS3 = AmazonS3ClientBuilder.standard()
    .withCredentials(new ProfileCredentialsProvider())
    .build()

  /**
   *
   * @return an instance of secret manager for region eu_west_3 with default profile
   */
  def secretsManager: AWSSecretsManager = AWSSecretsManagerClientBuilder.standard()
    .withRegion(Regions.EU_WEST_3)
    .build()

  /**
   *
   * @param secretsClient : AWSSecretsManager
   * @param secretName    : String corresponding to the desired SM-Key
   */
  def secretManagerValue(secretsClient: AWSSecretsManager, secretName: String): Option[String] = {

    try {
      val valueRequest = new GetSecretValueRequest().withSecretId(secretName)
      val valueResponse: GetSecretValueResult = secretsClient.getSecretValue(valueRequest)
      val secret = valueResponse.getSecretString
      Some(secret)

    } catch {
      case exception: AWSSecretsManagerException =>
        exception.printStackTrace()
        None
    }

  }
}
