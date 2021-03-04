package fr.cerbere.consulting.spark

import org.apache.spark.{SparkConf, SparkContext}

object CsvToCouchbaseApp {

  def main(args: Array[String]) = {
    val conf = new SparkConf().setAppName(this.getClass.getCanonicalName.toString)
    val sc = new SparkContext(conf)
    val rdd = sc.textFile("file:///home/user/cars.csv")
    println(rdd)
  }
}
