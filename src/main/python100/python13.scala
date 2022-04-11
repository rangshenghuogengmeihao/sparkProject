object python13 {
  def main(args: Array[String]): Unit = {
    for(n <- 100 until 1000){
      val i=(n /100).toInt
      val j =(n/10).toInt%10
      val k=n%10
      if (n==math.pow(i,3)+math.pow(j,3)+math.pow(k,3)){
        println(n)
      }
    }
  }
}
