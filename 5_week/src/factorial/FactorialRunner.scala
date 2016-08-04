package factorial

import scala.annotation.tailrec

/**
  * @author Vera Sidarovich
  */
object FactorialRunner extends App {


  def factorial(n: Int): Int = {
    @tailrec
    def factorialCalc(res: Int, nextVal: Int): Int = {
      if (nextVal <= 1) res else factorialCalc(res * nextVal, nextVal - 1)
    }
    factorialCalc(1, n)
  }

  println(factorial(1))
  println(factorial(2))
  println(factorial(3))
  println(factorial(4))
}



