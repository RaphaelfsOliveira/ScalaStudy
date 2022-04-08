package part2oop

import java.time.LocalDate

// class parameters are NOT FIELDS

class Person(name: String, val age: Int = 0) {
    // classes implementation
    val x = 2
    println(1 + 3)

    // method
    def greet(name: String): Unit = {
        println(s"${this.name} says: Hi $name")
    }

    // overloading method
    def greet(): Unit = {
        println(s"Hi, I am $name, $age years old")
    }

    // multiple contructors
    def this(name: String) = this(name, 0)

    def this() = this("John Doe")
}

class Writer(firstName: String, lastName: String, bithdayYear: Int) {
    
    def fullName(): String = {
        s"${this.firstName} ${this.lastName}"
    }

    def bithdayYear(): Int = {
        this.bithdayYear
    }

    def writeNewBook(name: String, yearOfRelease: Int): Novel = {
        new Novel(name, yearOfRelease, this)
    }
}

class Novel(name: String, val yearOfRelease: Int, author: Writer) {
    
    def authorAge(): Int = {
        LocalDate.now.getYear - this.author.bithdayYear
    }

    def isWrittenBy(author: Writer): Boolean = {
        author == this.author
    }

    def copy(year: Int): Novel = {
        new Novel(this.name, year, this.author)
    }

    def description(): String = {
        s"Book: ${this.name}, year: ${this.yearOfRelease} ${this.author.fullName}"
    }
}

class Counter(val count: Int) {

    def inc(): Counter = new Counter(count + 1) // immutability
    def dec(): Counter = new Counter(count - 1) // immutability

    def inc(n: Int): Counter = new Counter(count + n) // immutability
    def dec(n: Int): Counter = new Counter(count - n) // immutability
}

object OObasics extends App {
    val person = new Person("John", 37)
    
    println(person)
    println(person.age)
    println(person.x)
    person.greet("Daniel")
    person.greet()

    val person2 = new Person()
    println(person2)

    val writer = new Writer("Fiódor", "Dostoiévski", 1821)
    val novel = new Novel("Memórias do subsolo", 1864, writer)

    println(writer.fullName())
    println(novel.authorAge())
    println(novel.isWrittenBy(writer))

    val novel2 = novel.copy(2001)
    println(novel2)
    println(novel2.yearOfRelease)

    val newBook = writer.writeNewBook("Crime e Castigo", 1990)
    println(newBook)
    println(newBook.description)

}