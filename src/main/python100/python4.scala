object python4 {
  def main(args: Array[String]): Unit = {
    print("year:\n")
    var year = readInt()
    print("month:\n")
    var month = readInt()
    print("day:\n")
    var day = readInt()
    var sum = 0
    val months = Array(0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334)
    if (0 < month && month <= 12) {
      sum = months(month - 1)
    }
    else {
      print("data error")
    }
    sum += day
    var leap = 0
    if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0) {
      leap = 1
    }
    if (leap == 1 && month > 2) {
      sum += 1
    }
    printf("it is the %dth day.", sum)
  }
}
