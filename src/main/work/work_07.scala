import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object work_07 {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir","D:\\Program Files\\hadoop")
    val sparkConf =new SparkConf().setMaster("local[*]").setAppName("RDD")
    val sc = new SparkContext(sparkConf)
    val movie_title:RDD[String]=sc.textFile("input\\7\\movies.csv")
    val rating=sc.textFile("input\\7\\ratings.csv")
    val rating_tupleRDD:RDD[String] = rating.filter(_.!=("userId,movieId,rating,timestamp"))
    val rating_tupleRDD_contents:RDD[(String,Float)] = rating_tupleRDD.map(
      line => {
        val ID = line.split(",")(1)
        val score = line.split(",")(2).toFloat
        (ID, score)
      }
    )
    val ratingGroupRDD:RDD[(String,Iterable[Float])] = rating_tupleRDD_contents.groupByKey()
    val avgRDD:RDD[(String,Float)] = ratingGroupRDD.map(
      line => {
        var num = 0
        val sum = line._2.sum
        for (i <- line._2) {
          num += 1
        }
        val avg = sum / num
        (line._1, avg)
      }
    ).filter(line=>line._2>4)
    val title_tupleRDD:RDD[String] = movie_title.filter(_.!=("movieId,title,genres"))
    val title_tupleRDD_contents:RDD[(String,String)] = title_tupleRDD.map(
      line => {
        val ID = line.split(",")(0)
        val title = line.split(",")(1)
        (ID, title)
      }
    )
    val joinRDD:RDD[(String,(String,Float))] = title_tupleRDD_contents.join(avgRDD)
    val resultRDD:RDD[(String,Float)] = joinRDD.map(
      line => {
        line._2
      }
    )
    resultRDD.saveAsTextFile("output")
    sc.stop()
  }
}
