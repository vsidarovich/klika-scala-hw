/**
  * @author Vera Sidarovich
  */
object HighOrderFunction extends App {
  def foo[A, B, C](f: A => B, g: B => C): A => B = { param: A =>
    val f1 = f(param)
    g(f1)
    f1
  }

  def mult(a: Int): Int = a * 4

  def divide(a: Int) = a / 2

  println(foo[Int, Int, Int](mult, divide)(2))

}

