object python28 {
  def age(n: Int): Int = {
    var c: Int = 0
    if (n == 1) {
      c = 10
    }
    else {
      c = age(n - 1) + 2
    }
    c
  }
  def main(args: Array[String]): Unit = {
    print(age(5))
  }
}
