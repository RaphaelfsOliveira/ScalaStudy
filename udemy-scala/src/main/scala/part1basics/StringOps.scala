package part1basics

object StringOps extends App {

    val str: String = "Hello, I am learning Scala"

    println(str.charAt(2))
    println(str.substring(7, 11))
    println(str.split(" ").toList)

    println(str.replaceAll(",", "").split(" ").toList)
    println(str.toLowerCase().startsWith("hell"))

    println(str.replace(",", "").replace(" ", "_").toLowerCase())
    println(str.replace(",", "").replace(" ", "_").toUpperCase())

    println(str.length)

    val aNumberString = "2"
    val aNumber = aNumberString.toInt
    
    println('a' +: aNumberString :+ 'z')

    println(str.reverse)
    println(str.take(2))

    // Scala-specifir: String interpolators

    // S-interpolators
    

}