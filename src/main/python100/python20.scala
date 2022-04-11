object python20 {
  def main(args: Array[String]): Unit = {
    var tour = List[Double]()
    var height = List[Double]()
    var hei = 100.0 // 起始高度
    var tim = 10 // 次数
    for (i <- 1 to tim){
    // 从第二次开始，落地时的距离应该是反弹高度乘以2（弹到最高点再落下）
    if (i == 1) {
      tour= tour:+hei
    } else{
      tour=tour:+(2*hei)}
    hei /= 2
      height=height:+(hei)
  }
    println("总高度：tour = %f".format(tour.sum))
    println("第10次反弹高度：height = %f".format(height.last))
  }
}
