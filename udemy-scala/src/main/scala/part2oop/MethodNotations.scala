package part2oop

import scala.language.postfixOps


object MethodNotations extends App {
    
    class Person(val name: String, favoriteMovie: String, age: Int = 0) {
        
        def likes(movie: String): Boolean = {
            movie == favoriteMovie
        }

        def hangOutWith(person: Person): String = {
            s"${this.name} is hanging out with ${person.name}"
        }

        def +(person: Person): String = {
            s"${this.name} and ${person.name}"
        }

        def +(person: Person, favoriteMovie: String): String = {
            val newPerson = new Person(person.name, favoriteMovie)
            s"${newPerson.name} (${favoriteMovie})"
        }

        def unary_! : String = s"$name, what the heck?!"

        def isAlive: Boolean = true

        def apply(): Map[String, Any] = {
            Map(
                "name" -> this.name,
                "favoriteMovie" -> this.favoriteMovie,
                "age" -> this.age
            )
        }

        def apply(ageMore: Int): Map[String, Any] = {
            Map(
                "name" -> this.name,
                "favoriteMovie" -> this.favoriteMovie,
                "age" -> this.age.+(ageMore)
            )
        }

        def unary_+ : Person = {
            new Person(this.name, this.favoriteMovie, this.age + 1)
        }

        def learns(language: String): String = s"$name is learning $language"

        def learnsScala : String = {
            this learns "Scala"
        }
    }

    val mary = new Person("Mary", "Inception")

    // INFIX notation = operator notation
    println("######### INFIX notation #########")
    println(s"""mary likes "Inception" -> ${mary likes "Inception"}""")
    println(mary.likes("Inception"))
    // are equivalent

    // operators in Scala
    val tom = new Person("Tom", "The Arrival")

    println(mary hangOutWith tom)

    println(s"""mary + tom -> ${mary + tom}""")
    println(mary.+(tom))

    println(1 + 2)
    println(1.+(2))

    // all operators are methods

    // PREFIX notation
    // are equivalent
    println("######### PREFIX notation #########")
    val x = -1
    val y = 1.unary_-
    // unary_ prefix only works with - + ~ !
    
    // PREFIX notation 
    // are equivalent
    println(s"""!mary -> ${!mary}""")
    println(s"""mary.unary_! -> ${mary.unary_!}""")

    // POSTFIX notation
    // doesnt have any arguments
    println("######### POSTFIX notation #########")
    println(mary.isAlive)
    println(s"""mary isAlive -> ${mary isAlive}""")

    // APPLY
    println("######### APPLY #########")
    println(mary.apply())
    println(mary())

    // exercises #############################
    println("######### Exercises #########")
    
    println( mary.+(mary, "the rockstar") )

    println( (+mary)() )

    println(mary learns "Python")

    println(mary learnsScala)

    println(mary(10))
    

}