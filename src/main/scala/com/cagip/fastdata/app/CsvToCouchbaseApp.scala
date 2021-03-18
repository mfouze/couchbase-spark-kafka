package com.cagip.fastdata.app

import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

object CsvToCouchbaseApp {

  def main(args: Array[String]) = {
    val conf = new SparkConf().setAppName(this.getClass.getCanonicalName.toString).setMaster("local[1]")
    val sc = SparkContext.getOrCreate(conf)
    val rdd = sc.textFile("file:///data/cars.csv")
      .map { l => l.split(";")
      }

    val rdd2 = rdd
      .mapPartitionsWithIndex(
        (idx, iter) =>
          if (idx == 1) iter.drop(1) else iter
      )
    rdd.foreach {
      x =>
        println(s"C1->${x(0)}, C2->${x(1)}")
    }


  }
}

object CsvToCouchbaseSparkSessionApp extends App {
  val sparkSession = SparkSession
    .builder()
    .master("local[*]")
    .appName(this.getClass.getCanonicalName)
    .getOrCreate()

  sparkSession.sparkContext.setLogLevel("ERROR")


  val df = sparkSession
    .read
    .options(
      Map("inferSchema" -> "true", "delimiter" -> ";", "header" -> "true"))
    .csv("file:///data/mlb_players.csv")

  df.show()

  df.printSchema()

  /*

    val rddFromFile = sparkSession.sparkContext.textFile("file:///data/cars.csv")
    rddFromFile.map(f => {
      f.split(";")
    })
      .mapPartitionsWithIndex {
        (i, iter) =>
          if (i == 0) iter.drop(1) else iter
      }
      .collect()
      .foreach(a => println(a.toVector))

  */

}

object KafkaApp {
  def main(args: Array[String]) {
    println("Hello, world")
  }
}