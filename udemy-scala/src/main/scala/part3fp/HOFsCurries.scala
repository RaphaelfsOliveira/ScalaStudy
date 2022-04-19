package part3fp

import scala.annotation.tailrec

object HOFsCurries extends App {

  val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = null
  // higher order function (HOF)

  // map, flatMap, filter

  println("### higher order function (HOF) ###")

  @tailrec
  def nTimes(f: Int => Int, n: Int, x: Int): Int = {
    if (n <= 0) x
    else nTimes(f, n - 1, f(x))
  }

  val plusOne = (x: Int) => x + 1 // are equivalent
  val plusOne2: Int => Int = _ + 1 // are equivalent

  println(nTimes(plusOne, 10, 1))
  println(nTimes(plusOne2, 10, 1))
  println(nTimes(_ + 1, 10, 1))


  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) = {
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n - 1)(f(x))
  }

  val plus10 = nTimesBetter(plusOne2, 11)
  println(plus10(1))

  println("\n### curried functions ###")
  // curried functions
  val superAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
  val add3 = superAdder(4)
  println(add3(10))
  println(superAdder(4)(10))


  println("\n### functions with multiple params ###")
  // functions with multiple params
  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  val standartFormat: (Double => String) = curriedFormatter("%4.2f")
  val preciseFormat: (Double => String) = curriedFormatter("%10.8f")

  println(standartFormat(Math.PI))
  println(preciseFormat(Math.PI))


}
