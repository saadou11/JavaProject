package com.fsociety.jobs

import com.amazonaws.regions.Regions
import com.amazonaws.services.secretsmanager.{AWSSecretsManager, AWSSecretsManagerClient, AWSSecretsManagerClientBuilder}
import com.amazonaws.services.secretsmanager.model.{AWSSecretsManagerException, GetSecretValueRequest, GetSecretValueResult}
import com.fsociety.utils.AWSUtils
import com.fsociety.utils.AWSUtils.secretManagerValue

object GetSecretValue extends App {

  val USAGE = "\n" +
    "Usage:\n" +
    "    <secretName> \n\n" +
    "Where:\n" +
    "    secretName - the name of the secret (for example, tutorials/MyFirstSecret). \n"

  //if (args.length != 1) {
    //println(USAGE)
    //System.exit(1)
  //}

  val secretName = "args"
  val sm = AWSUtils.secretsManager
  println(secretManagerValue(sm, secretName))
  sm.shutdown()

}