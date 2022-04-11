object python33 {
  def main(args: Array[String]): Unit = {
    val L = List[Int](1, 2, 3, 4, 5)
    for (i <- 0 to L.length - 2) {
      print(L(i)+",")
    }
    print(L.last)
  }
}
