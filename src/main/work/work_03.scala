import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object work_03 {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "D:\\Program Files\\hadoop")
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")
    val sc = new SparkContext(sparkConf)
    val lines: RDD[String] = sc.textFile("input\\3\\file*.txt")
    val allRDD:RDD[String] = lines.coalesce(1)
    val wordRDD: RDD[Int] = allRDD.map(
      line => {
        val data = line.split(",")
        val payment = data(2)
        payment.toInt
      }
    )
    val result:RDD[Int] = wordRDD.sortBy(line => line,false)
    result.foreach(println)
//    result.saveAsTextFile("output")
    sc.stop()
  }
}
