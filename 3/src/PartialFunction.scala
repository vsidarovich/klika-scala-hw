/**
  * @author Vera Sidarovich
  */
object PartialFunction extends App {
  val sqrt: PartialFunction[Double, Double] = {
    case i if i > 0 => Math.sqrt(i)
  }

  println(sqrt.isDefinedAt(-1))
  println(sqrt.isDefinedAt(5))

  println(sqrt.apply(4))

}
