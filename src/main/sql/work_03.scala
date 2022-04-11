import org.apache.spark.SparkConf
import org.apache.spark.sql.{SaveMode, SparkSession}

object work_03 {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "D:\\Program Files\\hadoop")
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL")
    val spark = SparkSession.builder().config(sparkConf).getOrCreate()
    val RDD = spark.sparkContext.makeRDD(List((3, "Mary", "F", 26), (4, "Tom", "M", 23)))
    val df = spark.createDataFrame(RDD)
    df.write
      .format("jdbc")
      .option("url", "jdbc:mysql://localhost:3306/sparktest")
      .option("driver", "com.mysql.jdbc.Driver")
      .option("user", "root")
      .option("password", "root")
      .option("dbtable", "employee")
      .mode(SaveMode.Append)
      .save()

    spark.read.format("jdbc")
      .option("url","jdbc:mysql://localhost:3306/sparktest")
      .option("driver","com.mysql.jdbc.Driver")
      .option("user","root")
      .option("password","root")
      .option("dbtable","employee")
      .load().show()

    spark.close()
  }
}
