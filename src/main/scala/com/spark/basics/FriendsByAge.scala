package com.spark.basics

import org.apache.log4j._
import org.apache.spark._

object FriendsByAge {

  /** Our main function where the action happens */
  def main(args: Array[String]) {
    
    // Load up each line of the ratings data into an RDD
    val result = sc.textFile("../../resources/SparkScala/fakefriends.csv")
      .map(x => {
        val data = x.split(",")
        ((data(1), data(2).toInt), data(3).toInt)
      })
      .mapValues((_ , 1))
      .reduceByKey((x, y) => (x._1 + y._1, x._2 + y._2))
      .mapValues(x => x._1 / x._2)
      .map( x => (x._1._1, x._2))
      .collect()

    result.sorted.foreach(println)
  }
}
