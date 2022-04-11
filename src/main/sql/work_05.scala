import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object work_05 {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "D:\\Program Files\\hadoop")
    val sparkConf = new SparkConf().setMaster("local[*]")//.setAppName("sparkSQL")
    val spark = SparkSession.builder().config(sparkConf).getOrCreate()
//    spark.read.csv("data/course.csv").createOrReplaceTempView("course")
//    spark.read.csv("data/score.csv").createOrReplaceTempView("score")
//    spark.read.csv("data/student.csv").createOrReplaceTempView("student")
//    spark.read.csv("data/teacher.csv").createOrReplaceTempView("teacher")
//    //查询"01"课程比"02"课程成绩高的学生的信息及课程分数
//    spark.sql("select score").show()

    spark.close()
  }
}
