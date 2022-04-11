object List_ {
  def main(args: Array[String]): Unit = {
    var strList = List("BigData", "Hadoop", "Spark")
    //    一旦定义，不可修改
    //    head列表中的头部是第一个BigData
    //    tail列表中的尾部是除了头部以外的
    val intList1 = List(1, 2, 3)
    val intList2 = 1 :: 2 :: 3 :: Nil
    //    两者一样
    intList1.isEmpty
    //    是否为空

//    var list = List(1, 3, 2, 5, 4, 7, 8, 6, 9,0)
//    for (i <- 1 to 5) {
//      println(list(i))
//    }
//    println(list.contains(0))

    for (i <- 100 to  999){
      var bai=(i/100).toInt
      var shi=(i%10)/10.toInt
      var ge=i%10.toInt
      if (math.pow(bai,3)+math.pow(shi,3)+math.pow(ge,3)==i){
        println(i)
      }
    }
  }
}
