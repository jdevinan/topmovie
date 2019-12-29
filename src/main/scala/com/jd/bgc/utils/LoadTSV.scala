package com.jd.bgc.utils

import org.apache.spark.sql.{DataFrame, SparkSession}

object LoadTSV {

  /**
    * Read data from tsv file.
    *
    * @param spark, SparkSession object to convert input dataset file to DataFrame
    * @param dataFilePath the location of the tsv file. Currently, poinitng to datasets directory under resources.
    *                     it should be changed to HDFS location on the target Cluster.
    */
  def readData(spark: SparkSession, dataFilePath: String): DataFrame = {
    val titleRatings = spark.read
      .format("csv")
      .option("header", "true")
      .option("inferSchema", "true")
      .option("delimiter", "\t")
      .load(dataFilePath)
    titleRatings
  }

  // Paths to the IMDB source datasets for running on localhost. On Cluster environment, these files will be placed in distributed files system like HDFS
  def getDataFilePath(dataFilePath: String): String = {
    val filePath = getClass.getClassLoader.getResource(dataFilePath).getPath
    filePath
  }

}
