/**
  * @author Vera Sidarovich
  */

//add parametrization
case class Point(x: Double = 0.0, y: Double = 0.0) {

  def moveTo(v: Vector): Point = Point(this.x + v.x, this.y + v.y)

  def distance(p: Point): Double = Math.sqrt(Math.pow((p.x - this.x), 2) + Math.pow((p.y - this.y), 2))

  def compare(p: Point): Int = ???

  def detectQuarter(): Int = {
    this match {
      case _ if x > 0 && y > 0 => 1
      case _ if x > 0 && y < 0 => 2
      case _ if x < 0 && y < 0 => 3
      case _ if x < 0 && y > 0 => 4
    }
  }

  def isSymmetric(p: Point): Boolean = this.x + p.x == 0 && this.y + p.y == 0

  def isCollinear(p2: Point, p3: Point): Boolean = ((this.x * p2.y + p2.x * p3.y + p3.x * this.y) - (p2.x * this.y + p3.x * p2.y + this.x * p3.y)) / 2 > 0

  override def hashCode = x.hashCode() + y.hashCode() + 31

  override def toString = s"x = $x, y=$y"

}

case class Vector(x: Double, y: Double)


object Runner extends App {
  val point1 = Point(7.0, 10.0)

  println(point1.equals(Point(7.0, 10.0)))
  println(point1.hashCode)
  println(point1.toString)

  println(point1.moveTo(Vector(3, 5)))
  println(point1.distance(Point(6, -5)))
  println(point1.detectQuarter())
  println(point1.isSymmetric(Point(-7, -10)))
  println(point1.isCollinear(Point(-7, -10), Point(14, -20)))
}