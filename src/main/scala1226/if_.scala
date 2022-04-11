object if_ {
  def main(args: Array[String]): Unit = {
    val x = 6
    if (x > 0) {
      println("This is a positive number")
    }
    else if(x==0){}
    else {
      println("This is not a positive number")
    }

//    val x = 6
//    val a = if (x > 0) 1 else -1

    val a = 6
    if (a == 5) {
      println("a的值为5")
    }
    else if (a == 10) {
      println("a的值为10")
    }
    else {
      println("无法判断a的值")
    }
  }
}
