import scala.io.StdIn._

object match_ {
  def main(args: Array[String]): Unit = {
    println("Please input the score:")
    val grade = readLine()
    grade match {
      case "China" => println("中国")
      case "USA" => println("美国")
      case "C" => println("60-69")
      case "D" => println("<60")
      case _ => println("error input!")
    }
    for (elem <- List(6,9,0.618,"Spark","Hadoop","Hello")){
      val str=elem match {
        case i:Int=>i+" is an int value."
        case d:Double=> d+" is a double value."
        case "Spark"=>"Spark is found."
        case s:String=> s+" is a string value."
        case _=>"unexpected value: "+elem
      }
      println(str)
    }
  }
}
