package part2oop

object Objects {

    // scala does not have class-level functionality ("static")
    object Person { // type + its only instance
    // static/class - leval functionality
        val N_EYES = 2
        def canFly: Boolean = false

        def apply(mother: Person, father: Person): Person = new Person("Bobbie")
    }

    class Person(val name: String) {
        // instance-level functionality
    }
    // companions

    def main(args: Array[String]): Unit = {
        println(Person.N_EYES)
        println(Person.canFly)

        // Scala object = SINGLETON INSTANCE
        val mary = Person
        val john = Person
        println("### the same instance singleton ###")
        println(s"mary == john -> ${mary == john}")

        // Scala class = NEW INSTANCES
        val jack = new Person("Mary")
        val july = new Person("John")
        println("### two instances ###")
        println(s"jack != july -> ${jack != july}")

        val bobbie = Person(jack, july)
        println(bobbie, bobbie.name)

    }
}