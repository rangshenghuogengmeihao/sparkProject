import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object work_05 {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir","D:\\Program Files\\hadoop")
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")
    val sc=new SparkContext(sparkConf)
    val lines:RDD[String]=sc.textFile("input\\5")
    val allRDD:RDD[String]=lines.coalesce(1)
    val IntLineRDD:RDD[Int] = allRDD.map(
      word => word.toInt
    )
    val sortRDD:RDD[Int] = IntLineRDD.sortBy(a => a)
    val zipRDD:RDD[(Int,Long)] = sortRDD.zipWithIndex()
    val tupleRDD:RDD[(Long,Int)] = zipRDD.map(
      x =>
        (x._2 + 1, x._1)
    )
    val resultRDD:RDD[String] = tupleRDD.map(
      x => x._1 + "\t" + x._2
    )
    tupleRDD.saveAsTextFile("output")
  }
}