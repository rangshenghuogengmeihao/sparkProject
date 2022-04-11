object Iterator_ {
  def main(args: Array[String]): Unit = {
    val iter=Iterator("Hadoop","Spark","Scala")
//    一次性用品
    while (iter.hasNext){
      println(iter.next())
    }
  }
}
