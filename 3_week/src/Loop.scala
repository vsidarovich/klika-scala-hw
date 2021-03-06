/**
  * @author Vera Sidarovich
  */
object Loop {
  def whileLoop(condition: => Boolean)(callback: => Unit) {
    if (condition) {
      callback
      whileLoop(condition)(callback)
    }
  }
}

object LoopRunner extends App {
  val x = 100
  val condition = x > 0

  Loop.whileLoop(condition) {println( "Do something")}

}