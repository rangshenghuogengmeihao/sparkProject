import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object test_01 {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "D:\\Program Files\\hadoop")
    val sparkConf = new SparkConf()
      .setMaster("local[*]")
      .setAppName("test_01")
    val sparkSession = SparkSession.builder().config(sparkConf).getOrCreate()
    val dataframe = sparkSession.read.option("header", "true").option("encoding", "UTF-8").json("chinaskills/wm_5902.json")
    val jishuqiLongAccumulator = sparkSession.sparkContext.longAccumulator("jishuqi")
    val result = dataframe.filter(x => {
      var count = 0
      val lines = x.toString().split(",", -1)
      for (i <- lines) {
        if (i.trim.isEmpty||i.trim.toUpperCase == "NULL") {
          count += 1
        }
      }
      if (count > 3) {
        println(x)
        jishuqiLongAccumulator.add(1)
        false
      } else true
    })
    result.coalesce(1).write.mode("overwrite").option("header","true").option("encoding","UTF-8").json("diliveryoutput1")
    println("=== “删除缺失值大于3个的字段的数据条数为"+jishuqiLongAccumulator.value+"条”===")
    result.take(5).foreach(println)
  }
}
