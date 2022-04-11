object Set_ {
  def main(args: Array[String]): Unit = {
    var mySet = Set("Hadoop", "Spark")
    mySet += "Scala"
    //    如果要声明一个可变集，则需要提前引入scala.collection.mutable.Set
    //    键是唯一的，但值不一定是唯一的
    val xmu =if (mySet.contains("Scala")) mySet("Scala") else 0
    println(xmu)
  }
}
