package com.learnspark.utils

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession


trait Context{
  lazy val sparkConf = new SparkConf()
    .setAppName("Learn Spark")
    .setMaster("local")
    .set("spark.cores.max", "2")

  lazy val sparkSession = SparkSession
      .builder()
      .config(sparkConf)
      .getOrCreate()
}