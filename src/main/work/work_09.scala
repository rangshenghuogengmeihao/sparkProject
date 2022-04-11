import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object work_09 {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "D:\\Program Files\\hadoop")
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")
    val sc = new SparkContext(sparkConf)
    val lines: RDD[String] = sc.textFile("input\\9")
    lines.cache()
    val click: RDD[(String, Int)] = lines.filter(
      line => {
        val click_category_id = line.split(",")(6)
        click_category_id != "-1"
      }
    ).map(
      line => {
        (line.split(",")(6), 1)
      }
    ).reduceByKey(_ + _)
    val order: RDD[(String, Int)] = lines.filter(
      line => {
        val order_category_id = line.split(",")(8)
        order_category_id != ""
      }
    ).flatMap(
      line => {
        val order_category_id = line.split(",")(8)
        val strings = order_category_id.split("-")
        strings.map(
          line => (line, 1)
        )
      }
    ).reduceByKey(_ + _)
    val pay: RDD[(String, Int)] = lines.filter(
      line => {
        val pay_category_id = line.split(",")(10)
        pay_category_id != ""
      }
    ).flatMap(
      line => {
        val pay_category_id = line.split(",")(10)
        val strings = pay_category_id.split("-")
        strings.map(
          line => (line, 1)
        )
      }
    ).reduceByKey(_ + _)
    val rdd1 = click.map {
      case (cid, cut) => {
        (cid, (cut, 0, 0))
      }
    }
    val rdd2 = order.map {
      case (cid, cut) => {
        (cid, (0, cut, 0))
      }
    }
    val rdd3 = pay.map {
      case (cid, cut) => {
        (cid, (0, 0, cut))
      }
    }

    val sourceRDD = rdd1.union(rdd2).union(rdd3)
//    sourceRDD.saveAsTextFile("source")
    val analysisRDD = sourceRDD.reduceByKey(
      (t1, t2) => {
        (t1._1 + t2._1, t1._2 + t2._2, t1._3 + t2._3)
      }
    )
//    analysisRDD.saveAsTextFile("analysisRDD")
    val resultRDD = analysisRDD.sortBy(x => (x._2._1, x._2._2, x._2._3), false).take(10)
    resultRDD.foreach(println)


    //    val cogroupRDD: RDD[(String, (Iterable[Int], Iterable[Int], Iterable[Int]))] = click.cogroup(order, pay)
    //    cogroupRDD.mapValues {
    //      case (click, order, pay) => {
    //        var clickcount = 0
    //        if (click.iterator.hasNext) {
    //          clickcount = click.iterator.next()
    //        }
    //        var ordercount = 0
    //        if (order.iterator.hasNext) {
    //          ordercount = order.iterator.next()
    //        }
    //        var paycount = 0
    //        if (pay.iterator.hasNext) {
    //          paycount = pay.iterator.next()
    //        }
    //      }
    //    }
  }
}
