object python34 {
  def hello_runoob(): Unit = {
    println("RUNOOB")
  }

  def hello_runoobs(): Unit = {
    for (i <- 0 until 3) {
      hello_runoob()
    }
  }

  def main(args: Array[String]): Unit = {
    hello_runoobs()
  }
}
