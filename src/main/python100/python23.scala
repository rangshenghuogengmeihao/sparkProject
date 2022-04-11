object python23 {
  def main(args: Array[String]): Unit = {
    for (i <- 0 until 4) {
      for (j <- 0 until 2 - i + 1) {
        print(" ")
      }
      for (k <- 0 until 2 * i + 1) {
        print("*")
      }
      println("")
    }
    for (i <- 0 until 3) {
      for (j <- 0 until i + 1) {
        print(" ")
      }
      for (k <- 0 until 4 - 2 * i + 1) {
        print("*")
      }
      println("")
    }
  }
}
