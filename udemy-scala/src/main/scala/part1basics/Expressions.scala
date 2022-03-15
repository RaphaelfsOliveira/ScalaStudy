package part1basics

object Expressions extends App {
    val x = 1 + 2
    println(x)

    println(2 + 3 * 4)
    
    println(1 == x)

    val aCondition = true
    val condicionValue = if(aCondition) 5 else 3

    println(condicionValue)

    var z = 0
    println(z)

    if (aCondition) {
        z = 1
    } else {
        z = 2
    }

    println(z)

}