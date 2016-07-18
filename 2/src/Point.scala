/**
  * @author Vera Sidarovich
  */

//add parametrization
case class Point(x: Double = 0.0, y: Double = 0.0) {

  def moveTo(v: Vector): Point = Point(this.x + v.x, this.y + v.y)

  def distance(p: Point): Double = Math.sqrt(Math.pow((p.x - this.x), 2) + Math.pow((p.y - this.y), 2))

  def compare(p: Point): Int = this.compare(p)

  override def hashCode = x.hashCode() + y.hashCode() + 31

  override def toString = s"x = $x, y=$y"

}

case class Vector(x: Double, y: Double)


object Runner extends App {


  val point1 = Point(1.0, 1.0)

  val point2 = Point(1.0, 1.0)

  val str1 = new String("AAA00")

  val str2 = new String("AAA00")

  println(point1.equals(point2))

}