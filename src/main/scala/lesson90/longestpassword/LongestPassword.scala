package lesson90.longestpassword

import scala.math.Ordering

object Solution {

  val DELIMITER = ' '

  def solution(s: String): Int = {
    val aplhanumericalRegex = "[a-zA-Z0-9]*"
    def alphanumerical: String => Boolean = _.matches(aplhanumericalRegex)
    def isAToZLowerOrUpper: Char => Boolean = c => c.isLetter && c <= 'z'
    def evenNumberOfLetters: String => Boolean = _.filter(isAToZLowerOrUpper).length() % 2 == 0
    def oddNumberOfDigits: String => Boolean = _.filter(_.isDigit).length() % 2 == 1

    s
      .split(DELIMITER)
      .filter(alphanumerical)
      .filter(evenNumberOfLetters)
      .filter(oddNumberOfDigits)
      .map(_.length())
      .sortWith((a, b) => a > b)
      .headOption
      .getOrElse(-1)
  }
}