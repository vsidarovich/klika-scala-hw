/**
  * @author Vera Sidarovich
  */
case class D(val0: Double) {

  def + (that: D): D = D(this.val0 + that.val0)

  def - (that: D): D = D(this.val0 - that.val0)

  def * (that: D): D = D(this.val0 * that.val0)

  def / (that: D): D = D(this.val0 / that.val0)

  def +: (that: D): D = D(this.val0 + that.val0)

  def *: (that: D): D = D(this.val0 * that.val0)

}
