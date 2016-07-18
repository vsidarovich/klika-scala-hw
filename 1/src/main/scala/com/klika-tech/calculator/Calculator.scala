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

  def Factor = rule {Number | Parens}

  def Parens = rule {'(' ~ Expression ~ ')'}

  //transform digits to numbers
  def Number = rule {capture(NumericDigits) ~> (x => D(x.toDouble))}

  //capture digits from text
  def Digit = rule {oneOrMore(CharPredicate.Digit)}

  //capture Double/Integer digits from text
  def NumericDigits = rule {WhiteSpace ~ (oneOrMore(Digit ~ ('.') ~ Digit) | Digit) ~ WhiteSpace}

  //capture whitespaces
  def WhiteSpace = rule{zeroOrMore(" ")}

}

object CalculatorRunner extends App {
  println(new Calculator("2.4 +         1.222").InputLine.run())
  println(new Calculator("(2 + 5*2)/6").InputLine.run())
}
