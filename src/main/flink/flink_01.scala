import org.apache.flink.api.java.utils.ParameterTool
import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment
import org.apache.flink.streaming.api.windowing.time.Time

object flink_01 {
  def main(args: Array[String]): Unit = {
    //获取Socket端口号
    val port: Int = try {
      ParameterTool.fromArgs(args).getInt("port")
    } catch {
      case e: Exception => {
        System.err.println("No port set. use default port 9000--Scala")
      }
        9000
    }

    //获取运行环境
    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment

    //连接Socket获取输入数据
    val text = env.socketTextStream("hadoop100", port, '\n')

    //解析数据（把数据打平），分组，窗口计算，并且聚合求sum

    //注意：必须要添加这一行隐式转行，否则下面的FlatMap方法执行会报错
    import org.apache.flink.api.scala._

    val windowCounts = text.flatMap(line => line.split("\\s")) //打平，把每一行单词都切开
      .map(w => WordWithCount(w, 1)) //把单词转成word , 1这种形式
      .keyBy("word") //分组
      .timeWindow(Time.seconds(2), Time.seconds(1)) //指定窗口大小，指定间隔时间
      .sum("count")//sum或者reduce都可以
      //.reduce((a,b)=>WordWithCount(a.word,a.count+b.count))

    //打印到控制台
    windowCounts.print().setParallelism(1)

    //执行任务
    env.execute("Socket window count")
  }

  case class WordWithCount(word: String, count: Int)
  
}
