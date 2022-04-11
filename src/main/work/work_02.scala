import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object work_02 {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "D:\\Program Files\\hadoop")
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")
    val sc = new SparkContext(sparkConf)
    val tupleRDD: RDD[(String, Int)] = sc.makeRDD(List(("spark", 2), ("hadoop", 6), ("hadoop", 4), ("spark", 6)))
    val tupleGroupRDD: RDD[(String, Iterable[(String, Int)])] = tupleRDD.groupBy(
      tuple => tuple._1
    )
//    val tupleGroupRDD: RDD[(String, Iterable[(String, Int)])] = tupleRDD.reduceByKey()
//    val hebingRDD: RDD[(String, Int)] = tupleGroupRDD.map{
//      case (_, list) => {
//        list.reduce(
//          (t1, t2) =>
//            (t1._1, (t1._2 + t2._2) / 2)
//        )
//      }
////    }
//    tupleGroupRDD.saveAsTextFile("tupleGroupRDD")
    val hebingRDD = tupleGroupRDD.map {
      line=>{
        var num=0
        var sum = 0
        for (i <- line._2){
          num+=1
          sum+=i._2
        }
        val avg=sum/num
        (line._1,avg)
      }
    }
//    tupleRDD.collect().foreach(println)
//    tupleGroupRDD.collect().foreach(println)
    hebingRDD.collect().foreach(println)
  }
}
