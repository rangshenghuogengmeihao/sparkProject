object python1 {
  def main(args: Array[String]): Unit = {
    for (i <- 1 to 5) {
      for (j <- 1 to 5) {
        for (k <- 1 to 5) {
          if (i != j) {
            if (i != k) {
              if (j != k) {
                //                println(i+","+j+","+k)
                println(s"i=$i:j=$j,k=$k")
              }
            }
          }
        }
      }
    }
  }
}
