/**
  * @author Vera Sidarovich
  */
class Until() {
  def until(condition: Boolean) = {
    Loop.whileLoop(condition) {println("Inside until")}
  }
}

object UntilRunner extends App {

  def run() = {
    new Until()
  }

  var x = 10

  run().until(x > 0)
}