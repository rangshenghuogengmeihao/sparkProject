object python24 {
  def main(args: Array[String]): Unit = {
    var a = 2.0
    var b = 1.0
    var s:Double = 0
    var t:Double = 0
    for (n <- 1 until 21) {
      s += a / b
      t = a
      a = a + b
      b = t
    }
    print(s)
  }
}
