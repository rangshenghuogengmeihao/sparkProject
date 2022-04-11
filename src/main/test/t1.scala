import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object t1 {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "D:\\Program Files\\hadoop")
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")
    val sc = new SparkContext(sparkConf)
    val user: RDD[String] = sc.textFile("ml-100k/u.user", 1)
    val item: RDD[String] = sc.textFile("ml-100k/u.item")
    val data: RDD[String] = sc.textFile("ml-100k/u.data")
    val userRDD = user.map {
      line => {
        val id = line.split("|")
        //        val sex = line.split("|")
        //        val job = line.split("|")
        //        (id, sex, job)
        id
      }
    }
    //    userRDD.foreach(println)
    for (i <- userRDD) {
      var lines=""
      for (j <- i) {
        print(j)
        var line=""
        if (j!="|"){
          line+=j
        } else{
          println()
        }
      }

    }
  }
}
