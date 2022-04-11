object python32 {
  def main(args: Array[String]): Unit = {
    val a = List[String]("one", "two", "three")
    for (i <-( a.length - 1) to 0 by -1) {
      println(a(i))
    }
  }
}
