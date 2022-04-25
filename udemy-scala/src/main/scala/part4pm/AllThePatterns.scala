package part4pm

import part2oop._

object AllThePatterns extends App {

  // 1. Constants
  val x: Any = "Scala"
  val constants = x match {
    case 1 => "a number"
    case "Scala" => "The Scala"
    case true => "The Truth"
    case AllThePatterns => "A singleton object"
  }
  println(constants)

  // 2. match anything
  // 2.1 wildcard
  val matchAnything: Unit = x match {
    case _ =>
  }

  // 2.2 variable
  val matchVariable = x match {
    case something => s"I've found $something"
  }

  // 3. Tuples
  val aTuple = (1, 2)
  val matchATuple = aTuple match {
    case (1, 1) =>
    case (something, 2) => s"I've found $something"
  }

  val nestedTuple = (1, (2, 3))
  val matchNestedATuple: Unit = nestedTuple match {
    case (_, (2, v)) =>
  }
  // PMs can be NESTED (PMs podem ser aninhados)

  // 4. case classes - constructor pattern
  val aList: MyList[Any] = Cons(1, Cons(2), Empty)


}
