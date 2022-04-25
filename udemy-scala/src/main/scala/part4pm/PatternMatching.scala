package part4pm

import scala.util.Random

object PatternMatching extends App {

  // switch on steroids
  val random = new Random
  val x = random.nextInt(10)

  val description = x match {
    case 1 => "the One"
    case 2 => "double or nothing"
    case 3 => "third time is the charm"
    case _ => "something else" // _ = WILDCARD
  }
  println(s"$x -> $description")

  // 1. Decompose values
  case class Person(name: String, age: Int)
  val bob = Person("bob", 22)

  val greeting = bob match {
    case Person(n, a) if a < 21 => s"Hi, my name is $n and I am $a and I can't drink in the US"
    case Person(n, a) => s"Hi, my name is $n and I am $a years old"
    case _ => "I don't know who I am"
  }
  println(greeting)

  /*
  1. cases are matched in order
  2. what if no cases match ? MatchError
  3. type of PM expressions ? unified type of all types in all cases
   */

  // PM on sealed hierarchies (tem que ter todos os padrões se não pode dar erro)
  sealed class Animal
  case class Dog(name: String) extends Animal
  case class Cat(name: String) extends Animal

  val animal: Animal = Dog("Lua")

  animal match {
    case Dog(name) => println(s"Matched a dog with name $name")
    case Cat(name) => println(s"Matched a cat with name $name")
  }




}
