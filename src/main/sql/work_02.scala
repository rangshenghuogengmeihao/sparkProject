import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object work_02 {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "D:\\Program Files\\hadoop")
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL")
    val spark = SparkSession.builder().config(sparkConf).getOrCreate()
    val RDD = spark.sparkContext.textFile("sql/employee.txt")
    val value = RDD.map(
      line => User(line.split(",")(0).toInt, line.split(",")(1), line.split(",")(2).toInt)
    )
    val df = spark.createDataFrame(value)
    df.show()
  }
  case class User(id: Int, name: String, age: Int)
}
