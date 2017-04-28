package lesson90.flooddepth

import org.scalatest._

class FloodDepthSuite extends FunSuite {

  override def withFixture(test: NoArgTest) = { // Define a shared fixture
    // Shared setup (run at beginning of each test)
    try test()
    finally {
      // Shared cleanup (run at end of each test)
    }
  }

  test("no lakes - uphill should return 0") {
    assert(Solution.solution(Array(4, 5, 6)) == 0)
  }

  test("no lakes - plain should return 0") {
    assert(Solution.solution(Array(4, 4, 4)) == 0)
  }

  test("no lakes - plain and uphill should return 0") {
    assert(Solution.solution(Array(4, 4, 5, 5, 5, 6, 7, 7)) == 0)
  }

  test("one lake, not symmetric") {
    assert(Solution.solution(Array(3, 1, 2)) == 1)
  }

  test("one lake, 4,0,4 simple should return 4") {
    assert(Solution.solution(Array(4, 0, 4)) == 4)
  }

  test("two lakes, 1,3,2,1,2,1,5,3,3,4,2 simple should return 4") {
    assert(Solution.solution(Array(1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2)) == 2)
  }
}
