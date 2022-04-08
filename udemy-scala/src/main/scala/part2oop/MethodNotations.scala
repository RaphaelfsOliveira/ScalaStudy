package part2oop


object MethodNotations extends App {
    class Person(val name: String, favoriteMovie: String) {
        
        def likes(movie: String): Boolean = {
            movie == favoriteMovie
        }

        def hangOutWith(person: Person): String = {
            s"${this.name} is hanging out with ${person.name}"
        }

        def +(person: Person): String = {
            s"${this.name} and ${person.name}"
        }
    }

    val mary = new Person("Mary", "Inception")
    println(mary.likes("Inception"))

    println(mary likes "Inception")
    // infix notation = operator notation

    // operators in Scala
    val tom = new Person("Tom", "The Arrival")

    println(mary hangOutWith tom)

    println(mary + tom)
    println(mary.+(tom))

    println(1 + 2)
    println(1.+(2))

    // all operators are methods

    // prefix notation

}