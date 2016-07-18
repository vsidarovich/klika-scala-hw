package model

/**
  * @author Vera Sidarovich
  */
abstract class N(val0: Double) {
  abstract def + (that: N)

  abstract def - (that: N)

  abstract def * (that: N)

  abstract def / (that: N)

  def getVal0 = val0

}