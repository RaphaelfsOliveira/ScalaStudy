package part2oop


object Exceptions extends App {

  val x: String = null
  //  println(x.length)
  // this will crash java.lang.NullPointerException

  // 1. throwing and catching exceptions
//  val errorValue: String = throw new NullPointerException

  // 2. how to catch exceptions
  def getInt(withException: Boolean): Int = {
    if (withException) throw new RuntimeException("Exception Error Int")
    else 100
  }

  try {
    getInt(true)
  } catch {
    case _: RuntimeException => println("catch a RuntimeException")
  } finally {
    // code that will get executed no matter what
    println("finally program")
  }

  val fail = try { // AnyVal because maybe its Int maybe Unit
    getInt(true)
  } catch {
    case _: RuntimeException => 43
  } finally {
    // code that will get executed no matter what
    // optional and not influence the returnt type or this expressions
    println("finally program")
  }

  println(fail)

  // 3. How to define your own expcetions
  class MyException extends Exception
  val exception = new MyException
//  throw exception

  // java.lang.OutOfMemoryError: Requested array size exceeds VM limit
  //  val array = Array.ofDim(Int.MaxValue)

  //  java.lang.StackOverflowError
//  def infinite: Int = 1 + infinite
//  val noLimit = infinite

  class OverflowExcepction extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by 0")

  object PocketCalculator {
    def add(x: Int, y: Int): Any = {
      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw new OverflowExcepction
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x: Int, y: Int): Any = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowExcepction
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y: Int): Any = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowExcepction
      else if (x > 0 && y < 0 && result < 0) throw new UnderflowException
      else result
    }

    def divide(x: Int, y: Int): Any = {
      if (y == 0) throw new MathCalculationException
      else x / y
    }

  }

  println(PocketCalculator.divide(2, 0))

}
