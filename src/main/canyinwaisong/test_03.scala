import org.apache.spark.sql.SparkSession
import org.apache.spark.SparkConf
object test_03 {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir","D:\\Program Files\\hadoop")
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("test_03")
    val sparkSession = SparkSession.builder().config(sparkConf).getOrCreate()
//    val dataFrame = sparkSession.read.option("header", "true").option("encoding", "UTF-8").json("diliveryoutput2/part-00000-616ddd3e-be9e-485f-9f2c-7ba8346be74e-c000.json")
//    dataFrame.createOrReplaceTempView("dili2")
//    sparkSession.sql("select `申请时间`,`创建时间` from dili2").show(false)
//    sparkSession.sql("select datetime(`申请时间`)-datetime(`创建时间`) from dili2").show()
    val df = sparkSession.read.json("diliveryoutput2/part-00000-23345867-adb7-42de-857c-0d8d5571ea10-c000.json")
    //抽取第一题所用数据,转换成timestamp类型
    val name = "申请时间,创建时间"
    val data = df.select(name.split(",").map(a => df.col(a).cast("timestamp")):_*)
    //建表用sql语句操作
    data.createTempView("data")
    //unix_timestamp将timestamp转换成时间戳进行相减并求平均值,最后收集数据
    val avg = sparkSession.sql("select round(avg(unix_timestamp(`申请时间`,'yyyy-MM-dd HH:mm') - unix_timestamp(`创建时间`,'yyyy-MM-dd HH:mm'))/(1000*60)) AS avg from data").collect()
    println("=== “平均申请处理时长为" + avg.foreach(println) + "分钟”===")

  }
}
