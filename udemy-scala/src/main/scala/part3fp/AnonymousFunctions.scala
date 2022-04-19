package part3fp

object AnonymousFunctions extends App {

  // anonymous function (lambda)
  val doubler = (x: Int) => x * 2

  // multiple params in lambda
  val adder = (x: Int, y: Int) => x + y

  // no params
  val justDoSomething = () => 3

  // careful
  println(justDoSomething)
  println(justDoSomething())

  // curly braces with lambdas
  val stringToInt = {
    (str: String) => str.toInt
  }

  // syntatic sugar
  val niceIncrement: Int => Int = _ + 1 // equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ // equivalent to (a, b) => a + b

  println(niceIncrement(2))
  println(niceAdder(2, 2))

  val superAdder = (x: Int) => (y: Int) => x + y
  println(superAdder(3)(4))

}
