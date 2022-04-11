import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

object memoryRDD {
  def main(args: Array[String]): Unit = {
    val sparkConf=new SparkConf().setMaster("local[*]").setAppName("RDD")
    val sc =new SparkContext(sparkConf)

    val seq=Seq[Int](1,2,3,4)
    val rdd:RDD[Int]=sc.parallelize(seq)
    val rdd:RDD[Int] = sc.makeRDD(seq)

    rdd.collect().foreach(println)
    sc.stop()
  }
}
