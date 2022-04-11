import scala.io.StdIn._
object python17 {
  def main(args: Array[String]): Unit = {
    val s = readLine("请输入一个字符串:\n")
    var letters = 0
    var space = 0
    var digit = 0
    var others = 0
    for (c <- s) {
      if (c.isLower || c.isUpper) {
        letters += 1
      }
      else if (c.isSpaceChar) {
        space += 1
      }
      else if (c.isDigit) {
        digit += 1
      } else {
        others += 1
      }
    }
    printf("char = %d,space = %d,digit = %d,others = %d", letters, space, digit, others)
  }
}