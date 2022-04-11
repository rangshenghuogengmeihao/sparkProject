import scala.io.StdIn._

object python29 {
  def main(args: Array[String]): Unit = {
    var x = readLine("请输入一个数:\n").toInt
    var a = x / 10000
    var b = x % 10000 / 1000
    var c = x % 1000 / 100
    var d = x % 100 / 10
    var e = x % 10
    if (a != 0) {
      print("5 位数：" + e + d + c + b + a)
    }
    else if (b != 0) {
      print("4 位数：" + e + d + c + b)
    }
    else if (c != 0) {
      print("3 位数：" + e + d + c)
    }
    else if (d != 0) {
      print("2 位数：" + e + d)
    } else {
      print("1 位数：" + e)
    }
  }
}
