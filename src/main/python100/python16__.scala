import java.text.SimpleDateFormat
import java.util.Date
object python16__ {
  def main(args: Array[String]): Unit = {
    var date = new Date()
    val dateFormat: SimpleDateFormat = new SimpleDateFormat("dd/MM/yyyy")
    println(dateFormat.format(date))
    var date2 = new Date(41, 0, 5)
    println(dateFormat.format(date2))
    var date3 = new Date(41, 0, 6)
    println(dateFormat.format(date3))
    var date4 = new Date(41, 1, 5)
    println(dateFormat.format(date4))
  }
}
