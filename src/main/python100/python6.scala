object python6 {
  def fib(n: Int): Int = {
    if (n == 1 || n == 2) {
      return 1
    }
    fib(n - 1) + fib(n - 2)
  }

  def main(args: Array[String]): Unit = {
    println(fib(10))
  }
}
