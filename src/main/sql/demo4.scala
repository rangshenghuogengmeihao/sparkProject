import org.apache.spark.SparkConf
import org.apache.spark.sql.{Dataset, Encoder, Encoders, SparkSession, TypedColumn, functions}
import org.apache.spark.sql.expressions.Aggregator

object demo4 {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "D:\\Program Files\\hadoop")
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL")
    val spark = SparkSession.builder().config(sparkConf).getOrCreate()

//    val df = spark.read.json("datas/user.json")
    val df = spark.read.format("json").load("datas/user.json")
    spark.sql("select * from json.`datas/user.json`").show()
    df.createOrReplaceTempView("user")
    df.write.format("csv").save("output")
    import spark.implicits._
//    val ds:Dataset[User] = df.as[User]
    val udafCol:TypedColumn[User,Long] = new MyAvgUDAF().toColumn
    val rdd=spark.sparkContext.makeRDD(List((1,"zhangsan",30),(2,"zhangsan",30)))
//    val ds = rdd.map {
//      case (id, name, age) => {
//        User1(id, name, age)
//      }
//    }.toDS()
//    val df1 = ds.toDF()
//    df1.rdd
//    val rdd1 = ds.rdd
//    ds.select(udafCol).show()

    //spark3.0以后
    //spark.udf.register("ageAvg", functions.udaf(new MyAvgUDAF()))

    //spark.sql("select ageAvg(age) from user").show()


    spark.close()
  }

  /*
    继承org.apache.spark.sql.expressions.Aggregator
    IN:输入的数据类型
    BUF:缓冲区的数据类型
    OUT:输出的数据类型

   */
  case class User(username:String,age:Int)
  case class User1(id:Any,username:String,age:Int)
  case class Buff(var total: Long, var count: Long)

  class MyAvgUDAF extends Aggregator[User, Buff, Long] {
    //初始值或零值
    //缓冲区的初始化
    override def zero: Buff = {
      Buff(0L, 0L)
    }

    //根据输入的数据来更新缓冲区的数据
    override def reduce(buff: Buff, in: User): Buff = {
      buff.total = buff.total + in.age
      buff.count = buff.count + 1
      buff
    }

    //合并缓冲区
    override def merge(buff1: Buff, buff2: Buff): Buff = {
      buff1.total = buff1.total + buff2.total
      buff1.count = buff1.count + buff2.count
      buff1
    }

    //计算结果
    override def finish(buff: Buff): Long = {
      buff.total / buff.count
    }

    //缓冲区编码操作
    override def bufferEncoder: Encoder[Buff] = Encoders.product //自定义类使用product

    //输出的编码操作
    override def outputEncoder: Encoder[Long] = Encoders.scalaLong //已存在类使用scalaLong
  }
}
