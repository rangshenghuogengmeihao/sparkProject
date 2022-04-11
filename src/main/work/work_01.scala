import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object work_01 {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir","D:\\Program Files\\hadoop")
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")
    val sc = new SparkContext(sparkConf)

    val lines: RDD[String] = sc.textFile("input\\1")

    val words: RDD[String] = lines.flatMap(_.split(" "))
    val wordToOne: RDD[(String, Int)] = words.map(
      word => (word, 1)
    )
    val wordGroup: RDD[(String, Iterable[(String, Int)])] = wordToOne.groupBy(
      word => word._1
    )
    wordGroup.saveAsTextFile("output")
    val wordToCount:RDD[(String,Int)] = wordGroup.map {
      case (_,list)=>{
        list.reduce(
          (t1, t2) => {
            (t1._1, t1._2 + t2._2)
          }
        )
      }
    }

//    val wordToCount=wordToOne.reduceByKey(_+_)
    val rdd1 = wordToCount.coalesce(1)
//    rdd1.saveAsTextFile("output")
//    val wordToCount=wordToOne.reduceByKey(x,y=> {x + y})
    val array: Array[(String, Int)] = wordToCount.collect()
//    wordToCount.foreach(println)
    array.foreach(println)
    sc.stop()
  }
}
