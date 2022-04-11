import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object work_06 {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "D:\\Program Files\\hadoop")
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")
    val sc = new SparkContext(sparkConf)
    val lines: RDD[String] = sc.textFile("input\\6",1)
    val tupRDD:RDD[(String,String)] = lines.map(
      line => {
        val x = line.split(" ")(0)
        val y = line.split(" ")(1)
        (x, y)
      }
    )
//    val oneRDD:RDD[(String,String)] = tupRDD.coalesce(1)
//    x=>(主要关键字，次要)
    val sortRDD:RDD[(String,String)] = tupRDD.sortBy(x=>(x._1,x._2),false)
    val resultRDD:RDD[String] = sortRDD.map(
      x => {
        x._1 + " " + x._2
      }
    )
    resultRDD.saveAsTextFile("output")
//    resultRDD.saveAsTextFile("output")
    sc.stop()
  }
}
