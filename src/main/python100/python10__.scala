import java.text.SimpleDateFormat
import java.util.Date
object python10__ {
  def main(args: Array[String]): Unit = {
    def NowDate(): String = {
      val now: Date = new Date()
      val dateFormat: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
      val date = dateFormat.format(now)
      date
    }
    println(NowDate())
    Thread.sleep(1000)
    println(NowDate())
  }
}
