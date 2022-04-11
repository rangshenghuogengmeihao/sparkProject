object python7 {
  def main(args: Array[String]): Unit = {
    val a = List(1, 2, 3)
    var b=List[Int]()
    for (i <- 1 to a.length){
      b=b:+(a.indexOf(i)+1)
    }
    print(b)
  }
}
