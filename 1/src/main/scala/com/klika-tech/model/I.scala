/**
  * @author Vera Sidarovich
  */
case class I(val0: Int) {

  def + (that: I): I = I(this.val0 + that.val0)

  def - (that: I): I = I(this.val0 - that.val0)

  def * (that: I): I = I(this.val0 * that.val0)

  def / (that: I): I = I(this.val0 / that.val0)

  def +: (that: I): I = I(this.val0 + that.val0)

  def *: (that: I): I = I(this.val0 * that.val0)

}