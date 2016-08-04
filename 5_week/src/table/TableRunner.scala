package table

/**
  * @author Vera Sidarovich
  */

object TableRunner extends App {

  def and(a: Boolean, b: Boolean) = a && b

  def or(a: Boolean, b: Boolean) = a || b

  def not(a: Boolean) = !a

  def impl(a: Boolean, b: Boolean) = if (a) b else true

  def printTable(f: (Boolean, Boolean, Boolean) => Boolean) = {
    val values = List(true, false)
    for {
      a <- values
      b <- values
      c <- values
    } yield {
      printRow(a, b, c, f(a, b, c))
    }
  }

  def printRow(a: Boolean, b: Boolean, c: Boolean, res: Boolean) {
    println(s"$a \t $b \t $c \t $res")
  }

  println("A & B & C")
  printTable((a: Boolean, b: Boolean, c: Boolean) => and(a, and(b, c)))


  println("\n(A v В) → (В v С)")
  printTable((a: Boolean, b: Boolean, c: Boolean) => impl(or(a, b), or(b, c)))

  println("\n¬ А & (B v C)")
  printTable((a: Boolean, b: Boolean, c: Boolean) => and(not(a), or(b, c)))

}
