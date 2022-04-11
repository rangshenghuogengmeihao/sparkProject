object python26 {
  def fact(j: Int): Int = {
    var sum = 0
    if (j == 0) {
      sum = 1
    } else {
      sum = j * fact(j - 1)
    }
    sum
  }
  def main(args: Array[String]): Unit = {
    print (fact(5))
  }
}
