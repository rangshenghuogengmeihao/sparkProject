object for_ {
  def main(args: Array[String]): Unit = {
    for (i <- 1 to 5 if i % 2 == 0) println(i)
    for (i <- 0 to 9 if i > 5 && i % 2 == 0) println(i)
  }
}
