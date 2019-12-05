package com.learnspark.utils.dataframe

import com.learnspark.utils.Context



object DataFrameOperations extends App with Context{
  val dfTags = sparkSession
    .read
    .option("header", "true")
    .option("inferSchema", "true")
    .csv("src/main/resources/question_tags_10K.csv")
    .toDF("id", "tag")

  dfTags.show(10)

  val dfQuestionsCSV = sparkSession
    .read
    .option("header", false)
    .option("inferSchema", true)
    .option("dateFormat","yyyy-MM-dd HH:mm:ss")
    .csv("src/main/resources/questions_10K.csv")
    .toDF("id", "creation_date", "closed_date", "deletion_date", "score", "owner_userid", "answer_count")

  val dfQuestions = dfQuestionsCSV
    .filter("score > 400 and score < 410")
    .join(dfTags, "id")
    .select("owner_userid", "tag", "creation_date", "score")
    .toDF()

//  dfQuestions.show(10)

  //Convert DataFrame row to Scala case class
  import sparkSession.implicits._
  case class Tag(id: Int, tag: String)
//
    val dfTagOfTag = dfTags.as[Tag]

    dfTagOfTag
      .take(10)
      .foreach(t => println(s"id = ${t.id}, tag = ${t.tag}"))

  case class Question(owner_userid: Int, tag: String, creationDate: java.sql.Timestamp, score: Int)
  // create a function which will parse each element in the row

  def toQuestion(row: org.apache.spark.sql.Row): Question = {
    val IntOf: String => Option[Int] = _ match {
      case s if s == "NA" => None
      case s => Some(s.toInt)
    }

    import java.time._
    val DateOf: String => java.sql.Timestamp = _ match {
      case s => java.sql.Timestamp.valueOf(ZonedDateTime.parse(s).toLocalDateTime)
    }

    Question(
      owner_userid = IntOf(row.getString(0)).getOrElse(-1),
      tag = row.getString(1),
      creationDate = DateOf(row.getString(2)),
      score = row.getString(3).toInt

    )
  }


  val dfOfQuestion = dfQuestions.map(row => toQuestion(row))
  dfOfQuestion
    .take(10)
    .foreach(q => println(s"owner userid = ${q.owner_userid}, tag = ${q.tag}, creation date = ${q.creationDate}, score = ${q.score}"))


  val seqTags = Seq(
    1 -> "so_java",
    1 -> "so_jsp",
    2 -> "so_erlang",
    3 -> "so_scala",
    3 -> "so_akka"
  )

  val dfMoreTags = seqTags.toDF("id", "tag")
//  dfMoreTags.show()

  //DataFrame Union

  val dfUnionTags = dfTags
    .union(dfMoreTags)
    .filter("id in(1, 3)")
//
//  dfUnionTags.show(10)

  val dfIntersectionTags = dfMoreTags
    .intersect(dfUnionTags)
//  dfIntersectionTags.show(10)

  //Append column to DataFrame using withColumn()
  import org.apache.spark.sql.functions._
  val dfSplitColumn = dfMoreTags
    .withColumn("tmp", split('tag, "_"))
    .select(
      'id,
      'tag,
      'tmp.getItem(0).as("so_prefix"),
      'tmp.getItem(1).as("so_tag")
    ).drop('tmp)

//  dfSplitColumn.show(10)

  //Create DataFrame from Tuples
  val donuts = Seq(("plain donut", 1.50), ("vanilla donut", 2.0), ("glazed donut", 2.50))
 // val df = donuts.toDF("Donut Name", "Price")
  val df = sparkSession
      .createDataFrame(donuts)
      .toDF("Donut Name", "Price")
//  df.show()

  val columnNames: Array[String] = df.columns
//  columnNames.foreach(p => println(s"$p"))

//  println(df.dtypes)
  //column names and Type
  val(columnName, columnDataType) = df.dtypes.unzip
//  println(columnName)
//  println(columnDataType)
//  println(s"DataFrame column names = ${columnName.mkString(", ")}")
//  println(s"DataFrame column data types = ${columnDataType.mkString(", ")}")

  val tagsDF = sparkSession
    .read
    .option("multiline", true)
    .option("inferSchema", true)
    .json("src/main/resources/tags_sample.json")

//  tagsDF.show()

  val dfJson = tagsDF.select(explode($"stackoverflow") as "stackoverflow_tags")

  dfJson.show(false)

  dfJson.select(
    $"stackoverflow_tags.tag.id" as "id",
    $"stackoverflow_tags.tag.author" as "author",
    $"stackoverflow_tags.tag.name" as "tag_name",
    $"stackoverflow_tags.tag.frameworks.id" as "frameworks_id",
    $"stackoverflow_tags.tag.frameworks.name" as "frameworks_name"
  ).show(false)

  val donuts1 = Seq(("111","plain donut", 1.50), ("222", "vanilla donut", 2.0), ("333","glazed donut", 2.50))

  val dfDonuts1 = sparkSession
    .createDataFrame(donuts1)
    .toDF("Id","Donut Name", "Price")

  val inventory = Seq(("111", 10), ("222", 20), ("333", 30))
  val dfInventory = sparkSession
    .createDataFrame(inventory)
    .toDF("Id", "Inventory")

  val dfDonutsInventory = dfDonuts1.join(dfInventory, dfInventory.col("id").equalTo(dfDonuts1.col("id")), "inner")
  dfDonutsInventory.show()

  val tagsDF1 = sparkSession
    .read
    .option("multiLine", true)
    .option("inferSchema", true)
    .json("src/main/resources/tags_sample.json")

  val df1 = tagsDF1
    .select(explode($"stackoverflow") as "stackoverflow_tags")
    .select(
      $"stackoverflow_tags.tag.id" as "id",
      $"stackoverflow_tags.tag.author" as "author",
      $"stackoverflow_tags.tag.name" as "tag_name",
      $"stackoverflow_tags.tag.frameworks.id" as "frameworks_id",
      $"stackoverflow_tags.tag.frameworks.name" as "frameworks_name"
    )
//  df1.show()

  df1
    .select("*")
    .where(array_contains('frameworks_name, "Play Framework"))
//    .show()

  val donuts3 = Seq(("plain donut", 1.50), ("vanilla donut", 2.0), ("glazed donut", 2.50))
  val df3 = sparkSession.createDataFrame(donuts3).toDF("Donut Name", "Price")

  val priceColumnExists = df3.columns.contains("Price")
  println(s"Does price column exist = $priceColumnExists")

  //Split DataFrame Array column
  val targets4 = Seq(("Plain Donut", Array(1.50, 2.0)), ("Vanilla Donut", Array(2.0, 2.50)), ("Strawberry Donut", Array(2.50, 3.50)))
  val df4 = sparkSession
    .createDataFrame(targets4)
    .toDF("Name", "Prices")

  df4.printSchema()

  val df5 = df4
    .select(
      $"Name",
      $"Prices"(0).as("Low Price"),
      'Prices(1).as("High Price")
    )

//  df5.withColumnRenamed("Name", "Donut Name").show()
//  df5.show()

  //Create DataFrame constant column
  val donuts7 = Seq(("plain donut", 1.50), ("vanilla donut", 2.0), ("glazed donut", 2.50))
  val df7 = sparkSession.createDataFrame(donuts).toDF("Donut Name", "Price")

  val df8 = df7
    .withColumn("Tasty", lit(true))
    .withColumn("Correlation", lit(1))
    .withColumn("Stock Min Max", typedLit(Seq(100, 500)))

//  df8.show()

  val StockMinMax:(String => Seq[Int]) = (donutName: String) => donutName match {
    case "plain donut" => Seq(100, 500)
    case "vanilla donut"  => Seq(200, 400)
    case "glazed donut"   => Seq(300, 600)
    case _                => Seq(150, 150)
  }

  val udfStockMinMax = udf(StockMinMax)
  val df9 = df7
    .withColumn("Stock Min Max", udfStockMinMax($"Donut Name"))
//  df9.show()

  val firstRow = df7.first()

  val firstRowColumn1 = firstRow.get(0)

  val firstRowColumnPrice = firstRow.getAs[Double]("Price")

//  println(firstRowColumnPrice)

  //Format DataFrame column
  //We enrich our dataframe with the following formatted columns:
  //
  //Price Formatted: We use Spark's format_number() function to format price values by 2 decimal places.
  //Name Formatted: We use Spark's format_string() function to prepend the text "awesome" to donut names.
  //Name Uppercase: We use Spark's upper() function to convert the Donut Name values into uppercase.
  //Name lowercase: We use Spark's lower() function to convert the Donut Name value into lowercase.
  //Date Formatted: We use Spark's date_format() function to format the Purchase Date column using the format yyyyMMdd.
  //Day: We use Spark's dayofmonth() function to extract the day of the month from the Purchase Date.
  //Month: We use Spark's month() function to extract the month from the Purchase Date.
  //Year: We use Spark's year() function to extract the year from the Purchase Date.

  //DataFrame column hashing
  //Hash column: This column creates a hash values for column Donut Names. As per the Spark 2.0 API documentation, the hash() function makes use of the Murmur3 hash.
  //MD5 column: This column creates MD5 hash values for column Donut Names.
  //SHA-1 column: This column creates SHA-1 hash values for column Donut Names.
  //SHA-2 column: This column creates SHA-2 hash values for column Donut Names. For SHA-2, you will have to specify a second parameter for the number of bits. In the example below, I have chosen 256 as the number of bits.

  //DataFrame String Functions
  //Contains plain: This column uses the instr() function and outputs the index of the given substring in a column.
  //Length: This column uses the length() function and outputs the lengths for the string values in a column.
  //Trim: This column uses the trim() function and removes spaces on both sides of the text in a column.
  //LTrim: This column uses the ltrim() function and removes spaces from the left side of the text in a column.
  //RTrim: This column uses the rtrim() function and removes spaces from the right side of the text in a column.
  //Reverse: This column uses the reverse() function and outputs the text in reverse order in a column.
  //Substring: This column uses the substring() function and outputs the text in a column for the given from and to character indices.
  //IsNull: This column uses the isnull() function and outputs true or false if the text in a column is null or not.
  //Concat: This column uses the concat_ws() function and outputs a String representation of columns being concatenated. Note also that the concat_ws() function also allows you to provide a given textual separator.
  //InitCap: This column uses the initcap() function and converts the first letter for each word in the column into uppercase.

  //DataFrame drop null
   //using na.drop()

}

