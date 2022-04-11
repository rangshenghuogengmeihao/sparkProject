import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object hive_input {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf()
      .setMaster("local[*]")//申明spark运行模式
      .setAppName("hive_input")//设置job名称(可不写)

    val spark = SparkSession.builder()//spark-2.0采用SparkSession代替sparkContext
      .config(conf)
      .enableHiveSupport()//添加对HIVE的支持，否则无法访问hive库
      .getOrCreate()

    import spark.implicits._
    spark.read.format("jdbc")
      .option("driver","com.mysql.jdbc.Driver")
      .option("url","jdbc:hive2://192.168.23.69:9083/")
      .option("user","hive")
//      .option("password")
//      .option()

    spark.sql("use ods")

    val df= spark.sql("select * from customer")//在hive中执行sql语句，返回DataSet格式数据

    df.show()

    spark.stop()
  }
}
