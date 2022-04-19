package part3fp

import scala.annotation.tailrec

object HOFsCurries extends App {

//  val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = ???
  // higher order function (HOF)

  // map, flatMap, filter

  @tailrec
  def nTimes(f: Int => Int, n: Int, x: Int): Int = {
    if (n <= 0) x
    else nTimes(f, n - 1, f(x))
  }

  val plusOne = (x: Int) => x + 1
  val plusOne2: Int => Int = _ + 1
  println(nTimes(plusOne2, 10, 1))

}
