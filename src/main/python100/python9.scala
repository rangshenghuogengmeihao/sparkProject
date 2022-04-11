object python9 {
  def main(args: Array[String]): Unit = {
    for (i<-1 to 9) {
      print(i)
      Thread.sleep(1000)
    }
  }
}
