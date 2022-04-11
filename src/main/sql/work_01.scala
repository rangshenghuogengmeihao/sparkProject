import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object work_01 {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "D:\\Program Files\\hadoop")
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL")
    val spark = SparkSession.builder().config(sparkConf).getOrCreate()
val df = spark.read.json("sql/employee.json")
df.createTempView("user")
spark.sql("select * from user order by name desc").show()


    spark.close()
  }
}
