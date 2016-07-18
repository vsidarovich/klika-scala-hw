package model

/**
  * @author Vera Sidarovich
  */
case class I(val0: Int) extends N {

  override def + (that: N): N = D(this.val0 + that.getVal0)

  override def - (that: N): N = I(this.val0 - that.getVal0)

  override def * (that: N): N = I(this.val0 * that.val0)

  override def / (that: N): N = I(this.val0 / that.val0)

}
