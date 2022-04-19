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

  def toCurry(f: (Int, Int) => Int): (Int => Int => Int) = {
    x => y => f(x, y)
  }

  def fromCurry(f: (Int => Int => Int)): (Int, Int) => Int = {
    (x, y) => f(x)(y)
  }

  println("\n### FunctionX ###")
  // FunctionX
  def compose[A, B, C](f: A => B, g: C => A): C => B = {
    x => f(g(x))
  }

  def andThen[A, B, C](f: A => B, g: B => C): A => C = {
    x => g(f(x))
  }

  def superAdder2: (Int => Int => Int) = toCurry(_ + _)
  def add4: Int => Int = superAdder2(4)
  println(add4(17))

  val simpleAdder = fromCurry(superAdder)
  println(simpleAdder(4, 17))

  val add2 = (x: Int) => x + 2
  val times3 = (x: Int) => x * 3

  val composed = compose(add2, times3)
  val ordered = andThen(add2, times3)

  println(composed(4))
  println(ordered(4))






}
