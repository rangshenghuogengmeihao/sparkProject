import org.apache.spark.{SparkConf,SparkContext}
object Spark01_WordCount {
  def main(args: Array[String]): Unit = {
    //Application
    //Spark框架
    //TODO 建立和Spark框架的连接
    //JDBC : Connection
    val sparConf = new SparkConf().setMaster("local").setAppName("WordCount")
    val sc = new SparkContext()
    //TODO 执行业务操作

    //TODO 关闭连接
  }
}
