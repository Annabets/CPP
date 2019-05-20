import scala.collection.mutable.ListBuffer
import scala.math.abs;

object MyProgram {

  @annotation.tailrec
  def sqrIter(guess: Double, x: Double): Double =
    if (isGoodEnough(guess, x)) guess
    else sqrIter(improve(guess, x), x)

  def isGoodEnough(guess: Double, x: Double) =
    abs(guess * guess - x) < 0.0001

  def improve(guess: Double, x: Double) =
    (guess + x / guess) / 2

  def findAllSecondRootsRecursive(a: Int, b: Int): ListBuffer[String] = {
    val result = ListBuffer[String]()
    for (i <- a to b)
      result += sqrIter(1, i).formatted("%.2f")
    result
  }

  def main(args: Array[String]): Unit = {
    println(findAllSecondRootsRecursive(1, 9))
  }
}
