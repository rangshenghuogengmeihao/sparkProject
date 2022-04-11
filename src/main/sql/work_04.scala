import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.functions.mean
import org.apache.spark.sql.types.{StructField, StructType}
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}

object work_04 {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "D:\\Program Files\\hadoop")
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL")
    val spark = SparkSession.builder().config(sparkConf).getOrCreate()
    import spark.implicits._
//    val data = Array(1, 5, 7, 10, 23, 20, 6, 5, 10, 7, 10)
//    val dataRDD: RDD[Int] = spark.sparkContext.parallelize(data)
//    val df: DataFrame = dataRDD.toDF("value")
//    val ds: Dataset[Table] = df.as[Table]
//    val tupDF: Dataset[(Row, Int)] = df.map(
//      n => (n, 1)
//    )
//    tupDF.groupBy("value")
    val students=Array(("LiLei",18,87), ("HanMeiMei",16,77), ("DaChui",16,66), ("Jim",18,77), ("RuHua",18,50))
    val n=3
    val stuRDD = spark.sparkContext.makeRDD(students)
    val studf = stuRDD.toDF("name", "age", "score")
    studf.sort(studf("score").desc).show(n)

    //    spark.udf.register("tongji",)

    //    df.agg(mean("value")).show()
    //    df.agg({"value":"avgrage"})
    spark.close()
  }

  case class Table(value: Int)
  case class StudentTable(name:String,age:Int,score:Int)
}
