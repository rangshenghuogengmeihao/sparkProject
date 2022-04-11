import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.SparkConf


object test_04 {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("test_04")
    val sparkSession = SparkSession.builder().config(sparkConf).getOrCreate()
    val dataFrame = sparkSession.read.json("diliveryoutput2/part-00000-23345867-adb7-42de-857c-0d8d5571ea10-c000.json")
    val timesDataFrame: DataFrame = dataFrame.select("created_at", "updated_at")
    timesDataFrame.createTempView("table1")

    val before = sparkSession.sql("""select * from table1 where hour(`created_at`)<18 and hour(`updated_at`)-hour(`created_at`)>12 and date(`updated_at`)=date(`created_at`) """).count()//or hour(`created_at`)<18 and hour(`updated_at`)<6 and date(`updated_at`)>date(`created_at`)
    val after = sparkSession.sql("""select * from table1 where hour(`created_at`)>=18 and hour(`updated_at`)>12 and (day(`updated_at`)-date(`created_at`)=1)""").count()
    println("===18：00前递交申请的记录中，超时记录数为"+before+"条===")
    println("===18：00后递交申请的记录中，超时记录数为"+after+"条===")
    sparkSession.stop()

  }
}
//4396+1504