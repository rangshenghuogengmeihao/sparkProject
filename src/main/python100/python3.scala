object python3 {
  def main(args: Array[String]): Unit = {
    var j = 0
    for (i <- 1 to 84) {
      if (168 % i == 0) {
        j = 168 / i
        if (i > j && (i + j) % 2 == 0 && (i - j) % 2 == 0) {
          var m = (i + j) / 2
          val n = (i - j) / 2
          val x = n * n - 100
          println(x)
        }
      }
    }
  }
}
