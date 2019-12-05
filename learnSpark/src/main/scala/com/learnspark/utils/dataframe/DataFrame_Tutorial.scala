package com.learnspark.utils.dataframe

import com.learnspark.utils.Context

object DataFrame_Tutorial extends App with Context{
  val dfTags = sparkSession
    .read
    .option("header", "true")
    .option("inferSchema", "true")
    .csv("src/main/resources/question_tags_10K.csv")
    .toDF("id", "tag")

//  dfTags.show(10)

//  dfTags.printSchema()
//
//  dfTags.filter("tag == 'php'").show(10)
//
//  println(s"Number of php tags = ${dfTags.filter("tag == 'php'").count()}")
//
//  //filter
//  dfTags.filter("tag like 's%'").show(10)
//
//  //multiple filter chaining
//  dfTags
//    .filter("tag like 's%'")
//    .filter("id == 25 or id == 108")
//    .show(10)
//
//  dfTags.filter("id in(25, 108)").show(10)
//
//  dfTags.groupBy("tag").count().show()
//
//  dfTags.groupBy("tag").count().filter("count > 5").show(10)
//
//  dfTags.groupBy("tag").count().filter("count > 5").orderBy("tag").show(10)

  val dfQuestionCSV = sparkSession
    .read
    .option("header", "true")
    .option("inferSchema", "true")
    .option("dateFormat", "yyyy-MM-dd HH:mm:ss")
    .csv("src/main/resources/questions_10K.csv")
    .toDF("id", "creation_date", "closed_date", "deletion_date", "score", "owner_userid", "answer_count")

//  dfQuestionCSV.show(10)
//  dfQuestionCSV.printSchema()

  val dfQuestion = dfQuestionCSV.select(
    dfQuestionCSV.col("id").cast("integer"),
    dfQuestionCSV.col("creation_date").cast("timestamp"),
    dfQuestionCSV.col("closed_date").cast("timestamp"),
    dfQuestionCSV.col("deletion_date").cast("date"),
    dfQuestionCSV.col("score").cast("integer"),
    dfQuestionCSV.col("owner_userid").cast("integer"),
    dfQuestionCSV.col("answer_count").cast("integer")
  )

//  dfQuestion.printSchema()
//  dfQuestion.show(10)

  val dfQuestionsSubset = dfQuestion.filter("score > 400 and score < 410").toDF()
//  dfQuestionsSubset.show(10)

//  dfQuestionsSubset.join(dfTags, "id").show(10)
//  dfQuestionsSubset.join(dfTags, "id").select("owner_userid", "tag", "creation_date", "score").show(10)

//Join with explicit column
//  dfQuestionsSubset.join(dfTags, dfTags("id") === dfQuestionsSubset("id"))
//    .show(10)

  //inner, cross, outer, full, full_outer, left, left_outer, right, right_outer, left_semi, left_anti

//  dfQuestionsSubset.join(dfTags, Seq("id"), "inner")
//    .show(10)

//  dfTags.select("tag")
//    .distinct()
//    .show(10)




}
