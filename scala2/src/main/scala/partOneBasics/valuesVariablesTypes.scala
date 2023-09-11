package partOneBasics

object valuesVariablesTypes extends App {

//  VAL imutables

  val x: Int = 42
  println(x)

  val y = 43
  println(y)

  val hello: String = "Hello"
  val anotherString: String = "goodbye"
  println(hello)
  println(anotherString)

  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  println(aBoolean)
  println(aChar)

  val anInt: Int = x

  val aShort: Short = 4613
  val aLong: Long = 321312321312312321L
  println(aShort)
  println(aLong)

  val aFloat: Float = 2.0
  val aDouble: Double = 3.14
  println(aFloat)
  println(aDouble)


//  var mutables

  var a: Int = 20
  println(a)

  a = 15
  println(a)

}
