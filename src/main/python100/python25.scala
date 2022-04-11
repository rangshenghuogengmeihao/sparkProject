object python25 {
  def main(args: Array[String]): Unit = {
    var n = 0
    var s:Long = 0
    var t:Long = 1
    for (n <- 1 until 21) {
      t *= n
      s += t
    }
    printf("1! + 2! + 3! + ... + 20! = %d", s)
  }
}
