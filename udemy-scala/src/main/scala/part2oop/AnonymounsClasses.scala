package part2oop

object AnonymounsClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  // Anonumous class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("hhahahahahahhaa")
  }
  /*
  equivalent with

  class AnonymounsClasses$$anon$1 extends Animal {
    override def eat: Unit = println("hhahahahahahhaa")
   */

  println(funnyAnimal.eat)
  println(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi my name is $name")
  }

  val jim = new Person(name="Jim") {
    override def sayHi: Unit = println(s"Hi i'am Jim")
  }

  val person = new Person(name="Jack")

  println(person.sayHi)
  println(jim.sayHi)

}