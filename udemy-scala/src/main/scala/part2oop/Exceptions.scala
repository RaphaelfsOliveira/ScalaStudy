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

//  val memoryException = new OutOfMemoryError
  val stackException = new StackOverflowError

//  throw memoryException
  throw stackException

  class PocketCalculator {
    def add(x: Int, y: Int): AnyVal = {
      try {
        x + y
      } catch {
        case x > Int.MaxValue => throw StackOverflowError
        case y > Int.MaxValue => throw StackOverflowError
      } finally {
        println("error")
      }
    }

    def subtract(x: Int, y: Int): AnyVal = {
      try {
        x - y
      } catch {
        case x > Int.MinValue => throw IndexOutOfBoundsException
        case y > Int.MinValue => throw IndexOutOfBoundsException
      } finally {
        println("error")
      }
    }

  }




}
