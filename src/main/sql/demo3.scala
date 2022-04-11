import org.apache.spark.SparkConf
import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.expressions.{MutableAggregationBuffer, UserDefinedAggregateFunction}
import org.apache.spark.sql.types.{DataType, LongType, StructField, StructType}

object demo3 {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "D:\\Program Files\\hadoop")
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL")
    val spark = SparkSession.builder().config(sparkConf).getOrCreate()

    val df = spark.read.json("datas/user.json")
    df.createOrReplaceTempView("user")

    spark.udf.register("ageAvg",new MyAvgUDAF())

    spark.sql("select ageAvg(age) from user").show()


    spark.close()
  }

  class MyAvgUDAF extends UserDefinedAggregateFunction {
    //输入数据的结构 : In
    override def inputSchema: StructType = {
      StructType(
        Array(
          StructField(name = "name", dataType = LongType)
        )
      )
    }

    //缓冲区数据的结构 : Buff
    override def bufferSchema: StructType = {
      StructType(
        Array(
          StructField(name = "total", dataType = LongType),
          StructField(name = "count", dataType = LongType)
        )
      )
    }

    //函数计算结果的数据类型 : Out
    override def dataType: DataType = LongType

    //函数的稳定性
    override def deterministic: Boolean = true

    //缓冲区初始化
    override def initialize(buffer: MutableAggregationBuffer): Unit = {
      //buffer(0)=0L
      //buffer(1)=0L

      buffer.update(0, 0L)
      buffer.update(1, 0L)
    }

    //根据输入的值来更新缓冲区数据
    override def update(buffer: MutableAggregationBuffer, input: Row): Unit = {
      buffer.update(0, buffer.getLong(0) + input.getLong(0))
      buffer.update(1, buffer.getLong(1) + 1)
    }

    //缓冲区数据合并
    override def merge(buffer1: MutableAggregationBuffer, buffer2: Row): Unit = {
      buffer1.update(0, buffer1.getLong(0) + buffer2.getLong(0))
      buffer1.update(1, buffer1.getLong(1) + buffer2.getLong(1))
    }

    //计算平均值
    override def evaluate(buffer: Row): Any = {
      buffer.getLong(0)/buffer.getLong(1)
    }
  }
}
