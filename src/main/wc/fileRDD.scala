import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD
import org.apache.spark.repl.Main.sparkContext

object fileRDD {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")
    val sc = new SparkContext(sparkConf)
    val fileRDD: RDD[String] = sparkContext.textFile("input")
    fileRDD.collect().foreach(println)
    sc.stop()
  }

}
