import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}
import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD

object demo1 {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "D:\\Program Files\\hadoop")
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL")
    val spark = SparkSession.builder().config(sparkConf).getOrCreate()

    //    val df = spark.read.json("datas/user.json")
    //    df.createOrReplaceTempView("user")
    //
    //    spark.sql("select * from user").show()
    //    spark.sql("select age,username from user").show()
    //    spark.sql("select avg(age) from user").show()
    ////    DSL
    //    df.select("username","age").show()
    import spark.implicits._
    //    df.select($"age"+1).show()
    //    df.select('age+1).show()

    //    val seq = Seq(1, 2, 3, 4)
    //    val ds = seq.toDS()
    //    ds.show()

    //    RDD <=> DataFrame
    val rdd = spark.sparkContext.makeRDD(List((1, "zhangsan", 30), (2, "lisi", 40)))
    val df: DataFrame = rdd.toDF("id", "name", "age")
    val rowRDD: RDD[Row] = df.rdd

    //    DataFrame <=> Dataset
//    val ds: Dataset[User] = df.as[User]
//    val df1: DataFrame = ds.toDF()

    //    RDD <=> Dataset
//    val ds1:Dataset[User] = rdd.map {
//      case (id, name, age) => {
//        User(id, name, age)
//      }
//    }.toDS()
//    val userRDD:RDD[User]=ds1.rdd

    spark.close()
  }
}
