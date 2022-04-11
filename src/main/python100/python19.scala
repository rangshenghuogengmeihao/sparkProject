object python19 {
  def main(args: Array[String]): Unit = {
    for (j <- 2 to 1000) {
      var k = List[Int]()
      var n = -1
      var s = j
      for (i <- 1 until j) {
        if (j % i == 0) {
          n += 1
          s -= i
          k = k :+ i
        }
      }
      if (s == 0) {
        println(j)
        for (i <- 0 until n) {
          print((k(i)).toString)
          print(' ')
        }
        println(k(n))
      }
    }
  }
}
