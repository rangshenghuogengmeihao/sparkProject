import scala.util.control.Breaks._

object python36 {
  def main(args: Array[String]): Unit = {
    val lower = readLine("输入区间最小值: ").toInt
    val upper = readLine("输入区间最大值: ").toInt
    for (num <- lower to upper) {
      //素数大于 1
      if (num > 1) {
        breakable {
          for (i <- 2 until num) {
            if (num % i == 0) {
              break()
            }
          }
          println(num)
        }
      }
    }
  }
}