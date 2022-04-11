import org.apache.spark.SparkConf
import org.apache.spark.sql.{SaveMode, SparkSession}

object demo5 {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir","D:\\program Files\\hadoop")
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL")
    val spark = SparkSession.builder().config(sparkConf).getOrCreate()
    import spark.implicits._
    val df = spark.read.format("jdbc")
      .option("url","jdbc:mysql://localhost:3306/spark-sql")
      .option("driver","com.mysql.jdbc.Driver")
      .option("user","root")
      .option("password","root")
      .option("dbtable","user")
      .load()

    df.write
      .format("jabc")
      .option("url","jdbc:mysql://localhost:3306/spark-sql")
      .option("driver","com.mysql.jdbc.Driver")
      .option("user","root")
      .option("password","root")
      .option("dbtable","user")
      .mode(SaveMode.Append)
      .save()

  }
}
