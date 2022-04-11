import scala.io.StdIn._

object Array_ {
  def main(args: Array[String]): Unit = {
    //    val intValueArr = new Array[Int](3)
    //    intValueArr(0) = 12
    //    intValueArr(1) = 45
    //    intValueArr(2) = 33
    //    数组里的数据类型必须一致

    //    val stringArr = new Array[String](3)
    //    for (i <- 0 to 2) {
    //      stringArr(i) = readLine()
    //    }
    //    stringArr.foreach(print)

    val oushu = Array(2, 4, 6, 7)
    val newoushu = new Array[Int](4)
    for (i <- 0 to oushu.length - 1) {
      if (oushu(i) % 2 == 0) {
        newoushu(i) = oushu(i) * 10
      }
      else {
        newoushu(i) = oushu(i)
      }
    }
    newoushu.foreach(print)

//    多维数组
//    val myMatrix=Array.ofDim()[Int](3,4)
  }
}
