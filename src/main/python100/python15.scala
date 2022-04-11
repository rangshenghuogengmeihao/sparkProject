import scala.io.StdIn._

object python15 {
  def main(args: Array[String]): Unit = {
    print("输入分数:\n")
    val score = readInt()
    var grade: String = ""
    if (score >= 90) {
      grade = "A"
    }
    else if (score >= 60) {
      grade = "B"
    } else {
      grade = "C"
    }
    printf("%d 属于 %s", score, grade)
  }
}
