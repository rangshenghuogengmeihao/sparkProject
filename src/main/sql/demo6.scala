import org.apache.spark.SparkConf
import org.apache.spark.sql.{SaveMode, SparkSession}

object demo6 {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir","D:\\program Files\\hadoop")
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL")
    val spark = SparkSession.builder().enableHiveSupport().config(sparkConf).getOrCreate()


  }
}
