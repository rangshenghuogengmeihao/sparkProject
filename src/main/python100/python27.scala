import scala.io.StdIn.readLine
object python27 {
  def main(args: Array[String]): Unit = {
    var s = readLine("Input a string:")
    s.reverse.foreach(println)
  }
}
