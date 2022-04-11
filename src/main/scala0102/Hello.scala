class Hello(age: Int) {
  private val name: String = "Scala"

  def sayHello(): Unit = {
    println("姓名：" + name + "，年龄：" + age)
  }
}

object Hello {
  def apply(age: Int): Hello = {
    new Hello(age)
  }

  def main(args: Array[String]): Unit = {
    var hello = new Hello(20)
    hello.sayHello()
  }
}