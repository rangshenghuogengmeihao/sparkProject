import scala.io.StdIn._

object python18 {
  def main(args: Array[String]): Unit = {
    var Tn = 0
    var Sn = List[Int]()
    var n = readLine("n = ").toInt
    var a = readLine("a = ").toInt
    for (count <- 0 until n) {
      Tn = Tn + a
      a = a * 10
      Sn = Sn :+ Tn
      println(Tn)
    }
    print("计算和为："+ Sn.sum)
  }
}
