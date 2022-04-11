object python12 {
  def main(args: Array[String]): Unit = {
    var h = 0
    var leap = 1
    for (m <- 101 until 201){
      var k=math.sqrt(m+1).toInt
      for ( i <- 2 until k+1){
        if (m%i==0){
          leap=0
        }
      }
      if (leap==1){
        printf("%d\n",m)
        h+=1
        if (h%10==0){print("\n")}
      }
      leap=1
    }
    printf("The total is %d" , h)
  }
}
