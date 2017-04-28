package lesson90.longestpassword

import org.scalatest._

class LongestPasswordSuite extends FunSuite {

  override def withFixture(test: NoArgTest) = {
    try test()
    finally {
      //cleanup
    }
  }

  test("only a withespace should return -1") {
    assert(Solution.solution(" ") == -1)
  }

  test("only one number should return 1") {
    assert(Solution.solution("1") == 1)
  }

  test("only one number and two letters should return 3") {
    assert(Solution.solution("1aZ") == 3)
  }

  test("three of five are valid passwords, longest is 7") {
    assert(Solution.solution("test 5 a0A pass007 ?xy1") == 7)
  }

  test("odd amount of numbers and invalid characters should return -1") {
    assert(Solution.solution("123__") == -1)
  }
}