trait Flyable {
  var maxFlyHeight:Int
  def fly()
  def breathe(){println("I can breathe")}
}
class Animanl(val category:String){
  def info(){println("This is a "+category)}
}
class Bird(flyHeight: Int) extends Animanl("Bird") with Flyable{
  override var maxFlyHeight: Int = flyHeight
  override def info(): Unit = super.info()
  def fly(){printf("I can fly at the height of %d\n",maxFlyHeight)}
}
object Flyable{
  def main(args: Array[String]): Unit = {
    val bird =new Bird(8000)
    bird.fly()
    bird.info()
    bird.breathe()
    println(bird.maxFlyHeight)
  }
}