import util.control.Breaks._
object python14 {
  def reduceNum(n: Int): Unit = {
    var m = n
    printf("%d = ", m)
    if (m.getClass.getSimpleName == Int || m <= 0) {
      println("请输入一个正确的数字 !")
      System.exit(0)
    } else if (m == 1) {
      println(m)
    }
    while (m > 1) {
      breakable {
        for (index <- 2 until m + 1) {
          if (m % index == 0) {
            m = m / index
            if (m == 1) {
              println(index)
            } else {
              print(index + " * ")
            }
            break()
          }
        }
      }
    }
  }
  def main(args: Array[String]): Unit = {
    reduceNum(90)
    reduceNum(100)
  }
}
