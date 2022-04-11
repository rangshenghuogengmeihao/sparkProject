import scala.util.control.Breaks._

object python30 {
  def main(args: Array[String]): Unit = {
    var a = readLine("请输入一个数字:\n")
    var x = a.toString
    var flag: Boolean = true
    breakable {
      for (i <- 0 until (x.length / 2).toInt) {
        if (x(i) != x(x.length-i - 1)) {
          flag = false
          break
        }
      }
      if (flag) {
        printf("%s 是一个回文数!", a)
      } else {
        printf("%s 不是一个回文数!", a)
      }
    }
  }
}
