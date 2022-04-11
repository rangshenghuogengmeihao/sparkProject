import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object test_02 {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "D:\\Program Files\\hadoop")
    val sparkConf = new SparkConf()
      .setMaster("local[*]")
      .setAppName("test_02")
    val sparkSession = SparkSession.builder()
      .config(sparkConf)
      .getOrCreate()
    val dataFrame = sparkSession.read.option("header", "true")
      .option("encoding", "UTF-8")
      .json("diliveryoutput1/part-00000-581caab7-6127-40cb-8222-4541d79d7cbf-c000.json")
    dataFrame.createOrReplaceTempView("dili1")
    val jishuqiLongAccumulator = sparkSession.sparkContext.longAccumulator("jishuqi")
    val l:Long = sparkSession.sql("select * from dili1 where date(created_at)=date(updated_at) and date(`申请时间`)=date(`创建时间`)").count()
//    val l1 = sparkSession.sql("select count(*) from dili1").count()
//    sparkSession.sql("select count(*) from dili1 where date(created_at)=date(updated_at) and date(`申请时间`)=date(`创建时间`)").show()
    println("===两组属性同时相等的数据条数为"+l+"条===")
    dataFrame.coalesce(1)
      .write
      .mode("overwrite")
      .option("header","true")
      .option("encoding","UTF-8")
      .json("diliveryoutput2")

    sparkSession.stop()




  }
}
