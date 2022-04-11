class Student {
  var name = "小宇"
  var age = 20
  var score = List(100,100,100)

//  def student(name: String, age: Int.type, yuwen: Int, shuxue: Int, yinyu: Int) = {
//    this.name = name
//    this.age = age
//    this.score(0) = yuwen
//    this.score(1) = shuxue
//    this.score(2) = yinyu
//  }

  def get_name(): String = {
    name
  }

  def get_age(): Int = {
    age
  }

  def get_course(): Int = {
//    var max = Int
//    for (i <- 0 until score.length - 1) {
//      if (score(i) >= score(i + 1)) {
//        max = score(i)
//      } else {
//        max = score(i + 1)
//      }
//    }
    score.max
  }
}

object Student {
  def main(args: Array[String]): Unit = {
    val student = new Student

    student
  }
}