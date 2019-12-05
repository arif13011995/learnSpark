package com.learnspark.utils.dataframe

import com.learnspark.utils.Context

object SparkSQL_Tutorial extends App with Context{
  val dfTags = sparkSession
    .read
    .option("header", "true")
    .option("inferSchema", "true")
    .csv("src/main/resources/question_tags_10K.csv")
    .toDF("id", "tag")

  dfTags.createOrReplaceTempView("so_tags")
//  sparkSession.catalog.listTables().show()
//  sparkSession.sql("show tables").show()

//  //select column
//  sparkSession
//    .sql("select id, tag from so_tags limit 10")
//    .show()
//  // Filter by column value
//  sparkSession
//    .sql("select * from so_tags where tag = 'php'")
//    .show(10)

//   Count number of rows
//  sparkSession
//    .sql(
//      """
//        |select
//          |count(*) as php_count
//        |from so_tags
//        |where tag = 'php'
//      """.stripMargin)
//    .show(10)

  // Typed dataframe, filter and temp table
  val dfQuestionsCSV = sparkSession
    .read
    .option("header", "true")
    .option("inferSchema", "true")
    .option("dateFormat","yyyy-MM-dd HH:mm:ss")
    .csv("src/main/resources/questions_10K.csv")
    .toDF("id", "creation_date", "closed_date", "deletion_date", "score", "owner_userid", "answer_count")


  // cast columns to data types
  val dfQuestions = dfQuestionsCSV.select(
    dfQuestionsCSV.col("id").cast("integer"),
    dfQuestionsCSV.col("creation_date").cast("timestamp"),
    dfQuestionsCSV.col("closed_date").cast("timestamp"),
    dfQuestionsCSV.col("deletion_date").cast("date"),
    dfQuestionsCSV.col("score").cast("integer"),
    dfQuestionsCSV.col("owner_userid").cast("integer"),
    dfQuestionsCSV.col("answer_count").cast("integer")
  )

  // filter dataframe
  val dfQuestionsSubset = dfQuestions.filter("score > 400 and score < 410").toDF()

  // register temp table
  dfQuestionsSubset.createOrReplaceTempView("so_questions")

  def prefixStackOverFlow(s:String): String = s"so_$s"

  sparkSession
    .udf
    .register("prefix_so", prefixStackOverFlow _)

  sparkSession
    .sql("""select id, prefix_so(tag) from so_tags""".stripMargin)
    .show(10)
}
