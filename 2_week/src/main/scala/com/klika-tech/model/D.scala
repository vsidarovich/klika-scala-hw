/**
  * @author Vera Sidarovich
  */
case class D(val0: Double = 0.0) {

  def + (that: D): D = D(this.val0 + that.val0)

  def - (that: D): D = D(this.val0 - that.val0)

  def * (that: D): D = D(this.val0 * that.val0)

  def / (that: D): D = D(this.val0 / that.val0)

  def +: (that: D): D = D(this.val0 + that.val0)

  def *: (that: D): D = D(this.val0 * that.val0)

  override def toString() = val0.toString
}