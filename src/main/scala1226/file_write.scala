import java.io.PrintWriter
object file_write {
  def main(args: Array[String]): Unit = {
    val out = new PrintWriter("output.txt")
    for (i <- 1 to 5) out.println(i)
    out.close()
  }
}
