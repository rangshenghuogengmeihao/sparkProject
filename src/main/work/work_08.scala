import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object work_08 {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "D:\\Program Files\\hadoop")
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")
    val sc = new SparkContext(sparkConf)
    val lines:RDD[String] = sc.textFile("input\\8")
    val tupleRDD:RDD[(Int,Int)] = lines.map(
      line => {
        val a = line.split(" ")(1).toInt
        val b = line.split(" ")(4).toInt
        (a, b)
      }
    )
    val groupRDD:RDD[(Int,Iterable[Int])] = tupleRDD.groupByKey()
    val sumgroupRDD:RDD[(Int,Int)] = groupRDD.map(
      line => {
        (line._1, line._2.sum)
      }
    )
    val sortRDD:RDD[(Int,Int)] = sumgroupRDD.coalesce(1).sortBy(a=>a._2,false)
    sortRDD.take(3).foreach(println)
//    sumgroupRDD.saveAsTextFile("output")
//    sortRDD.saveAsTextFile("output")
    sc.stop()
  }
}
