package playground

object ValuesVariablesTypes extends App {

    // VALS are imutable

    // compiler can infer types

    val x: Int = 42
    val y = 45
    
    val sString: String = "Hello"
    val anotherString = "goodbye"

    val aBoolean: Boolean = false
    val aChar: Char = 'a'
    
    val anInt: Int = x
    val aShort: Short = 4613
    val aLong: Long = 432423148
    
    val aFloat: Float = 2.0f
    val aDouble: Double = 3.14

    println(x)
    println(y)
    println(sString)
    println(anotherString)

    println(aBoolean)
    println(aChar)
    
    println(anInt)
    println(aShort)
    println(aLong)
    
    println(aFloat)
    println(aDouble)

    // variables are mutable
    var z: Int = 1
    println(z)

    z += 1
    println(z)
    
    z += 1
    println(z)

}
