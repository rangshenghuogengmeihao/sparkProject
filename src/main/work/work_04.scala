import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object work_04 {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "D:\\Program Files\\hadoop")
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")
    val sc = new SparkContext(sparkConf)
    val lines: RDD[String] = sc.textFile("input\\4")
    val allRDD: RDD[String] = lines.coalesce(1)
    val allIntRDD: RDD[Int] = allRDD.map(
      a => a.toInt
    )
    val tupleRDD = allIntRDD.map(
      x => ("key", x)
    )
    val groupRDD = tupleRDD.groupByKey()
    val resultRDD = groupRDD.map(
      x => {
        var max = Integer.MIN_VALUE
        var min = Integer.MAX_VALUE
        for (i <- x._2) {
          if (i > max) {
            max = i
          }
          if (i < min) {
            min = i
          }
        }
        (max, min)
      })
//    resultRDD.collect().foreach(println)
    resultRDD.saveAsTextFile("output")
    sc.stop()
  }
}
