import io.Source
object file_read {
  def main(args: Array[String]): Unit = {
    val inputFile=Source.fromFile("output.txt")
    val lines=inputFile.getLines()
    for (line <- lines) println(line)
  }
}
