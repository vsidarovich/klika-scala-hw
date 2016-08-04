package extractors

import scala.util.matching.Regex

/**
  * @author Vera Sidarovich
  */

object StringExtractor extends App {

  trait CustomRegexp {

    val regex = new String

    def unapply(args: String): Option[List[String]] = find(regex.r, args)

    def find(r: Regex, string: String) = {
      val matched = r.findAllIn(string).toList
      if (matched.isEmpty) None else Some(matched)
    }
  }

  object HexExtractor extends CustomRegexp {
    override val regex = """0[xX][0-9a-fA-F]+"""
  }

  object EmailExtractor extends CustomRegexp {
    override val regex = """[a-zA-Z0-9\.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*"""
  }

  object UrlExtractor extends CustomRegexp {
    override val regex = "https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,4}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)"
  }


  def findMatch(randomString: String): List[String] = {
    randomString match {
      case HexExtractor(matched)   => matched
      case EmailExtractor(matched) => matched
      case UrlExtractor(matched)   => matched
      case _                       => List.empty
    }
  }

  println(findMatch("ololo string 0xABCDEF 0xCD vsfmq@yandex.ru https://ololo.com"))
  println(findMatch("ololo string test@yandex.com, test@test.com"))
  println(findMatch("https://ololo.com"))
  println(findMatch("https ololo"))
}
