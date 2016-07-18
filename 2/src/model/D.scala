package model

/**
  * @author Vera Sidarovich
  */
case class D (val0: Double) {

  override def + (that: N): N = D(this.val0 + that.val0)

  override def - (that: N): N = D(this.val0 - that.val0)

  override def * (that: N): N = D(this.val0 * that.val0)

  override def / (that: N): N = D(this.val0 / that.val0)

}
