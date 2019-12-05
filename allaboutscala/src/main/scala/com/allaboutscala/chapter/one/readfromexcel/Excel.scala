package com.allaboutscala.chapter.one.readfromexcel

import org.apache.spark.sql._
import org.apache.spark.{SparkConf, SparkContext}

object Excel{
  val conf: SparkConf = new SparkConf()
    .setMaster("local")
    .setAppName("readfromexcel")
  val spark: SparkSession = SparkSession
              .builder
              .appName("readfromexcel")
              .master("local")
              //.config(conf)
              .getOrCreate()

  val sc: SparkContext = spark.sparkContext
  val sqlContext: SQLContext = spark.sqlContext

  val df = spark.read
    .format("com.crealytics.spark.excel")
    .option("useHeader", "true")
    .load("D:\\Arief\\DevelopYS\\scala\\allaboutscala\\sources\\test.xlsx")

  val csv = spark.read.format("csv")
    .option("header", "true")
    .load("D:\\Arief\\DevelopYS\\scala\\allaboutscala\\sources\\test.csv")


  val df1 = sqlContext.read
    .format("com.crealytics.spark.excel")
    .option("sheetName", "abcd")
    .option("useHeader", "true")
    //.option("dataAddress", "C3:D7")
    .load("D:\\Arief\\DevelopYS\\scala\\allaboutscala\\sources\\test.xlsx")


  def main(args: Array[String]): Unit = {
    println("Excel123")
    //println(df1.show())
    val excel = spark.read.format("com.crealytics.spark.excel")
      //.option("sheetName", "abcd")
      //.option("dataAddress", "'1'!A1:D8")
     // .option("dataAddress", "'abcd'!A1:D8")
      .option("useHeader", "true")
      .option("treatEmptyValuesAsNulls", "true")
      .option("inferSchema", "false")
      .option("addColorColumns", "False")
      .option("timestampFormat", "MM-dd-yyyy HH:mm:ss")
     //.option("location", "D:\\Arief\\DevelopYS\\scala\\allaboutscala\\sources\\test.xlsx")
      .load("D:\\Arief\\DevelopYS\\scala\\allaboutscala\\sources\\test.xlsx")
        //.load()

    println(excel.show())

//    println("csv")
//    println(csv.show())
  }

}
