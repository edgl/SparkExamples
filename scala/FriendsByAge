package main.scala

import org.apache.spark.SparkContext

/**
  * Created by egleeck on 9/24/17.
  */

object FriendsByAge {
  def parseLine(line:String) = {
    val fields = line.split(",")
    val age = fields(2).toInt
    val numFriends = fields(3).toInt
    (age, numFriends)
  }

  def main(args: Array[String]) {

    val sc = new SparkContext("local[*]", "FriendByAge");

    val lines = sc.textFile("data/fakefriends.csv")

    val rdd = lines.map(parseLine)

    val totalsByAge = rdd.mapValues(x => (x, 1)).reduceByKey( (x,y) => (x._1 + y._1, x._2 + y._2))

    val averagesByAge = totalsByAge.mapValues(x => x._1 / x._2)

    val results = averagesByAge.collect()

    results.sorted.foreach(println)
  }
}

