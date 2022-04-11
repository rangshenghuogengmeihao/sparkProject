import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object test_05 {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("test_05")
    val sparkSession = SparkSession.builder().config(sparkConf).getOrCreate()
    sparkSession.read.json()

    sparkSession.stop()
  }
}
