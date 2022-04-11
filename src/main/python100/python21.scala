object python21 {
  def main(args: Array[String]): Unit = {
    var x2 = 1
    var x1 = 0
    for (day <- 9 until 0 by -1) {
      x1 = (x2 + 1) * 2
      x2 = x1
    }
    print(x1)
  }
}
