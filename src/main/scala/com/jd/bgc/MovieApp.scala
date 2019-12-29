package com.jd.bgc

import com.jd.bgc.utils.LoadTSV
import org.apache.log4j._
import org.apache.spark.sql._
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

object MovieApp {

  /** Our main function where the action happens */
  def main(args: Array[String]) {

    // Set the log level to only print errors
    //Logger.getLogger("com.jd.bgc").setLevel(Level.ERROR)
    Logger.getLogger("org").setLevel(Level.ERROR)

    // Use new SparkSession interface in Spark 2.0
    val spark = SparkSession
      .builder
      .appName("MovieApp")
      .master("local[*]") // this line should be commented, when running on Cluster environment - to distribute the load across the Workers/Executors in the Cluster.
      .getOrCreate()

    //    Q1. Retrieve the top 20 movies with a minimum of 50 votes with the ranking determined by:
    //     (numVotes/averageNumberOfVotes) * averageRating

    // Paths to the IMDB source datasets for running on localhost. On Cluster environment, these files will be placed in distributed files system like HDFS
    val titleRatingsPath= LoadTSV.getDataFilePath("datasets/title.ratings.tsv")
    val titleCrewPath=LoadTSV.getDataFilePath("datasets/title.crew.tsv")
    val crewNamesPath=LoadTSV.getDataFilePath("datasets/name.basics.tsv")
    val titleNamesPath=LoadTSV.getDataFilePath("datasets/title.basics.tsv")

    // class to infer the schema.
    import spark.implicits._
    // Convert input tsv file to DataSet
    val titleRatings: DataFrame = LoadTSV.readData(spark, titleRatingsPath)

    println("Filter out Titles with less than 50 votes and compute ranking:")
    // Ranking formaula is assumed and computed as follows: (numVotes/averageNumberOfVotes) * averageRating.
    // NOTE: used a date field to perform partitioning since no suitable field was found in datasets to use for this purpose.
    val ranking = titleRatings
        .filter(titleRatings("numVotes") > 50)
        .withColumn("date_title", lit("20191228"))
        .withColumn("averageNumberOfVotes", avg($"numVotes").over(Window.partitionBy($"date_title")))
        .withColumn("ranking", (col("numVotes")/col("averageNumberOfVotes"))*col("averageRating"))
        .orderBy($"ranking".desc)
        .limit(20)
        //.show()

    val titleCrew: DataFrame = LoadTSV.readData(spark, titleCrewPath)
//    println("Title crew:")
//    titleCrew.show()

    val crewNames: DataFrame = LoadTSV.readData(spark, crewNamesPath)
    val creditedPersons =  ranking.join(titleCrew, "tconst")

    // Q2. For these 20 movies, list the persons who are most often credited and list the different titles of the 20 movies.

//    println("Credited Persons by names:")
    val creditedPersonsByNames = creditedPersons
      .join(crewNames, creditedPersons.col("directors").contains(crewNames.col("nconst")),"inner")
      .select("tconst",  "averageRating", "numVotes", "averageNumberOfVotes", "ranking", "primaryName", "primaryProfession")

    val titleNames: DataFrame = LoadTSV.readData(spark, titleNamesPath)

    val topRatedTitleAndCreditedPersonsByNames = creditedPersonsByNames.join(titleNames, "tconst")
      .select("primaryTitle",  "averageRating", "numVotes", "averageNumberOfVotes", "ranking", "primaryName", "primaryProfession")

    println("Top Rated Titles And Credited Persons By Names:")
    // Rename columns in DataFrame to make it more human readable format.
    val newColumns = Seq("Primary Title","Average Rating","Number of Votes","Average Number Of Votes","Ranking","Primary Credited Name","Primary Credited Profession")
    val columnsRenamed = topRatedTitleAndCreditedPersonsByNames.toDF(newColumns:_*)
    columnsRenamed.show();

    spark.stop()
  }


}