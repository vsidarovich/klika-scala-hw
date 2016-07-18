import org.parboiled2.{ParserInput, _}

/**
  * @author Vera Sidarovich
  */
class Calculator(val input: ParserInput) extends Parser {
  def InputLine = rule {Expression ~ EOI}

  def Expression: Rule1[D] = {
    rule {Term ~ zeroOrMore(
      '+' ~ Term ~> ((_: D) + _)
          |
      '-' ~ Term ~> ((_: D) - _))
    }
  }

  def Term = {rule {Factor ~ zeroOrMore('*' ~ Factor ~> ((_: D) * _)
          |
      '/' ~ Factor ~> ((_: D) / _))
    }
  }

  def Factor = rule {DoubleNumber | Parens | IntNumber}

  def Parens = rule {'(' ~ Expression ~ ')'}

  //transform Double digits to double
  def IntNumber = rule {capture(Digits) ~> (x=>D(x.toDouble))}

  //transform digits to numbers
  def DoubleNumber = rule {capture(DoubleDigits) ~> (x=>D(x.toDouble))}

  //capture Integer digits from text
  def Digits = rule {oneOrMore(CharDigit)}

  //capture Double digits from text
  def DoubleDigits = rule {oneOrMore(CharDigit) ~ ('.') ~ oneOrMore(CharDigit)}

  def CharDigit=rule {CharPredicate.Digit}
}

object CalculatorRunner extends App {

  object Calculator {
    def apply(input: String) = {
      val replaced = input.replace(" ", "")
      println(replaced)
      new Calculator(replaced)
    }
  }

  println(Calculator.apply("2 + 1.2").InputLine.run()) // evaluates to `scala.util.Success(2)`
}



