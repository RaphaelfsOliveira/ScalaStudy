package part4pm

object BracelessSyntax {
  // if expressions
  val anIfExpression = if (2 > 3) "bigger" else "smaller"

  // java-style
  val anIfExpression_v2 =
    if (2 > 3) {
      "bigger"
    } else {
      "smaller"
    }

  // compact
  val anIfExpression_v3 =
    if (2 > 3) "bigger"
    else "smaller"

  // scala 3
  val anIfExpression_v4 =
    if 2 > 3 then
      "bigger" // higher indentation than if part
    else
      "smaller"

  val anIfExpression_v5 =
    if 2 > 3 then
      val result = "bigger"
      result
    else
      val result = "smaller"
      result

  // scala 3 one-liner
  val anIfExpression_v6 = if 2 > 3 then "bigger" else "smaller"

  // for comprehensions
  val aForComprehensions = for {
    n <- List(1,2,3)
    s <- List("black", "white")
  } yield s"$n$s"

  // scala 3
  val aForComprehensions_v2 =
    for
      n <- List(1,2,3)
      s <- List("black", "white")
    yield s"$n$s"

  // pattern matching
  val meaningOfLife = 42
  val aPatternMatch = meaningOfLife match {
    case 1 => "the One"
    case 2 => "double or nothing"
    case _ => "something else"
  }

  // scala 3
  val aPatternMatch = meaningOfLife match
    case 1 => "the One"
    case 2 => "double or nothing"
    case _ => "something else"

  // or
  val aPatternMatch =
    meaningOfLife match
      case 1 => "the One"
      case 2 => "double or nothing"
      case _ => "something else"

  // methods without
  def compute(arg: Int): Int = {
    val partialResult = 40
    partialResult + 2
  }

  // scala 3
  // function indentation
  def compute_v2(arg: Int): Int =
    val partialResult = 40
    arg + partialResult

  // scala 3
  // class indentation
  class Animal:
    def eat(): Unit =
      println("eating")


  def main(args: Array[String]): Unit = {}

}
