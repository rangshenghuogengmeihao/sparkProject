object python2 {
  def main(args: Array[String]): Unit = {
    print("净利润")
    var i = readInt()
    val arr = Array(1000000, 600000, 400000, 200000, 100000, 0)
    val rat = Array(0.01, 0.015, 0.03, 0.05, 0.075, 0.1)
    var r = 0.0
    for (idx <- 0 to 5) {
      if (i > arr(idx)) {
        r += (i - arr(idx)) * rat(idx)
        println((i - arr(idx)) * rat(idx))
        i = arr(idx)
      }
    }
    println(r)
  }
}
