object python8 {
  def main(args: Array[String]): Unit = {
    for (i <- 1 to 9) {
      for (j <- 1 to i) {
        printf("%d*%d=%d\t", j, i, i * j)
      }
      println()
    }
  }
}
