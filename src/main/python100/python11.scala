object python11 {
  def main(args: Array[String]): Unit = {
    var f1 = 1
    var f2 = 1
    for (i <- 1 until 22) {
      print("%12d%12d".format(f1, f2) )
      if (i % 3 == 0) {
        print("\n")
      }
      f1 = f1 + f2
      f2 = f1 + f2
    }
  }
}
