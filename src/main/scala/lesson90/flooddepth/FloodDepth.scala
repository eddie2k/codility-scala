package lesson90.flooddepth

object Solution {
  def solution(a: Array[Int]): Int = {
    def op(acc: Accumulator, x: Int): Accumulator = {
      x match {
        case x if (x >= acc.localHighestPoint) => new Accumulator(Math.max(acc.absMaxDepth, acc.localHighestPoint - acc.localLowestPoint), x, x)
        case x if (x < acc.localHighestPoint && x > acc.localLowestPoint) => new Accumulator(Math.max(acc.absMaxDepth, x - acc.localLowestPoint), acc.localHighestPoint, acc.localLowestPoint)
        case _ => new Accumulator(acc.absMaxDepth, acc.localHighestPoint, x)
      }
    }

    a.foldLeft(new Accumulator(0, 0, 0))(op).absMaxDepth
  }
}

class Accumulator(val absMaxDepth: Int, val localHighestPoint: Int, val localLowestPoint: Int)