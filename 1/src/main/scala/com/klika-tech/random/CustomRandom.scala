/**
  * @author Vera Sidarovich
  */

trait CustomRandom {
  def nextInt: (Int, CustomRandom)
}

object CustomRandomFactory {
  def createRandom(seed: Long): CustomRandom = {

    new CustomRandom {
      def nextInt = {
        val randomValue = (seed * 0x5DEECE66DL + 0xBL).asInstanceOf[Int]
        //current random value. next CustomRandom instance based on the current random value
        (randomValue, createRandom(randomValue))
      }
    }
  }
}


object CustomRandomRunner extends App {
  val initialNumber = 1234

  var (random,nextState1) = CustomRandomFactory.createRandom(initialNumber).nextInt

  //randomized value based on manipulations with initialNumber
  print(random)

  val (randomVal0, newNextState0) = nextState1.nextInt
  val (randomVal1, newNextState1) = nextState1.nextInt
  val (randomVal2, newNextState2)= nextState1.nextInt

  //should be the same
  println(randomVal0)
  println(randomVal1)
  println(randomVal2)

  val (newRandomVal, nexNextState2)=newNextState0.nextInt

  //should be different
  println(randomVal0)
  println(newRandomVal)
}



