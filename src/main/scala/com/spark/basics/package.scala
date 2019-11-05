package com.spark

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext

package object basics {

  // Set the log level to only print errors
  Logger.getLogger("org").setLevel(Level.ERROR)

  // Create a SparkContext using every core of the local machine, named RatingsCounter
  implicit lazy val sc = new SparkContext("local[*]", "FriendsByAge")


}
