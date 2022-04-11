object python5 {
  def main(args: Array[String]): Unit = {
    var l = Array[Int]()
    for (i <- 0 to 2) {
      print("integer:\n")
      var x = readInt()
      l = l :+ x
    }
    println(l.sorted.toBuffer)
  }
}
