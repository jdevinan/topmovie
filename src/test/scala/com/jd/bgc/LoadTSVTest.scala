package com.jd.bgc


import org.apache.spark.{SparkConf, SparkContext}
//import org.scalatest.{FunSuite, Matchers}

import com.jd.bgc.utils.LoadTSV
import org.apache.spark.sql.{DataFrame, SparkSession}

//object LoadTSVTest {
//
////  // Use new SparkSession interface in Spark 2.0
////  val spark = SparkSession
////    .builder
////    .appName("MovieApp")
////    .master("local[*]") // this line should be commented, when running on Cluster environment - to distribute the load across the Workers/Executors in the Cluster.
////    .getOrCreate()
//
//
//  // Paths to the IMDB source datasets for running on localhost. On Cluster environment, these files will be placed in distributed files system like HDFS
//  val titleRatingsPath= LoadTSV.getDataFilePath("datasets/title.ratings.tsv")
//
//  // class to infer the schema.
//  import spark.implicits._
////
////  // Convert input tsv file to DataSet
////  val titleRatings: DataFrame = LoadTSV.readData(spark, titleRatingsPath)
////
////  titleRatings.show()
//
////  val titleCrewPath=LoadTSV.getDataFilePath("datasets/title.crew.tsv")
////  val crewNamesPath=LoadTSV.getDataFilePath("datasets/name.basics.tsv")
////  val titleNamesPath=LoadTSV.getDataFilePath("datasets/title.basics.tsv")
//
//
//}

//
//class test extends FunSuite with DataFrameSuiteBase {
//  test("simple test") {
//    val sqlCtx = sqlContext
//    import sqlCtx.implicits._
//
//    val input1 = sc.parallelize(List(1, 2, 3)).toDF
//    assertDataFrameEquals(input1, input1) // equal
//
////    val input2 = sc.parallelize(List(4, 5, 6)).toDF
////    intercept[org.scalatest.exceptions.TestFailedException] {
////      assertDataFrameEquals(input1, input2) // not equal
////    }
//  }
//}

//}