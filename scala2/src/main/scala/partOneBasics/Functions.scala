package partOneBasics

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("test", 6))

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("Scala", 6))

  def greeting(name: String, age: Int): String = {
    "Hi, my name is " + name + " and i'm " + age + "years old."
  }

  def factorial(n: Int): Float = {
    if (n <= 0) 1
    else n * factorial(n - 1)
  }

  def fibonacci(n: Int): Int = {
    if (n <= 2) 1
    else fibonacci(n - 1) + fibonacci( n - 2)
  }

  println(greeting("David", 12))
  println(factorial(5))
  println(fibonacci(8))

}
