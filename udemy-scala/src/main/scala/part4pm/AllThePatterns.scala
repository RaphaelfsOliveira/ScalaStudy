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
  val aList: MyList[Int] = Cons(1, Cons(2, Empty))
  val matchAList: Unit = aList match {
    case Empty =>
    case Cons(head, tail) =>
  }

  // 5. list patterns
  val standardList = List(1, 2, 3, 4)
  val standardListMatching: Unit = standardList match {
    case List(1, _, _, _) => // extractor - advanced
    case List(1, _*) => // List or arbitrary length - advanced
    case 1 :: List(_) => // infix pattern
    case List(1, 2, 3) :+ 4 => // infix pattern
  }

  // 6. type specifies
  val unknown: Any = 2
  val unknownMatch = unknown match {
    case list: List[Int] => // explicit type specified
    case _ =>
  }

  // 7. name binding
  val nameBindingMatch = aList match {
    case nonEmptyList @ Cons(h, t) => // name binding => use name later(here)
    case Cons(1, rest @ Cons(2, _)) => // name binding inside nested patterns
  }

  // 8. multi-patterns
  val multiPattern = aList match {
    case Empty | Cons(0, _) => // compound pattern (multi-pattern)
  }

  // 9. if guards
  val secondElementSpecial = aList match {
    case Cons(_, Cons(specialElement, _)) if specialElement % 2 == 0 => // if conds
  }

  // ALL.



}
