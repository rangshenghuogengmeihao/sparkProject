import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}
//import org.spark_project.jetty.server.Authentication.User

object demo2 {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "D:\\Program Files\\hadoop")
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL")
    val spark = SparkSession.builder().config(sparkConf).getOrCreate()
    import spark.implicits._
    val df = spark.read.json("datas/user.json")
    df.createOrReplaceTempView("user")
    spark.udf.register("prefixName",(name:String)=>{
      "Name:"+name
    })
    spark.sql("select age,'Name:' + username from user").show()



    spark.close()
  }
}
