package part1basics

object DefaultArgs extends App {

    def trFact(n: Int, acc: Int = 1): Int = {
        if (n <= 1) acc
        else trFact(n - 1, n * acc)
    }

    val fact10: Int = trFact(10)

    println(fact10)

    def hello(firstName: String = "John", lastName: String = "Wick", age: Int = 43): Unit = {
        println(firstName + " " + lastName + " " + age)
    }

    hello(age = 70)
}
