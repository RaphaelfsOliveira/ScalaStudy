package partOneBasics

object Expressions extends App {

  val aSum: Int = 1 + 2
  println(aSum)

  println(2 + 3 * 4)

  println(1 == aSum)

  println(!(1 == aSum))

  var aVariable: Int = 2
  aVariable += 3
//  println(aVariable)

  val aCondition: Boolean = true
  val aConditionValue: Int = if(aCondition) 5 else 3
  println(aConditionValue)

  var i: Int = 0
  while (i < 10) {
    println(i)
    i += 1
  }

  val aWeirdValue = (aVariable = 3) // Unit === void
  println(aWeirdValue)

  //    The value of the block is the value of the last expression
  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }
  println(aCodeBlock)

}
