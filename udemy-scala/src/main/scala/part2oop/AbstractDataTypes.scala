package part2oop

object AbstractDataTypes extends App {
    
    // abstract 
    // não podem ser instanciadas 
    // geralmente são referências de metodos e valores
    // que tem que ser implementados nas classes filho
    abstract class Animal {
        val creatureType: String
        def eat: Unit
    }

    class Dog extends Animal {
        val creatureType: String = "Canine"
        def eat: Unit = println("crunch, crunch")
    }

    // traits
    // também são classes abstratas
    trait Carnivore {
        def eat(animal: Animal): Unit
    }

    trait ColdBlood

    class Crocodile extends Animal with Carnivore with ColdBlood {
        val creatureType: String = "reptile"
        
        def eat: Unit = println("nomoomomo")
        
        def eat(animal: Animal): Unit = {
            println(s"I'm ${this.creatureType} i'm eating ${animal.creatureType}")
        }
    }

    val dog = new Dog
    val croc = new Crocodile

    croc.eat(dog)
    
    // syntax sugar
    croc eat dog

    // traits vs abstract class
    // 1 - Você pode extender uma classe mas pode
    // concatenar varias traits (assim tem a possibilidade de implementar)
    // herença multipla em Scala
    // 2 - classes abstratas normalmente descrevem objetos 
    // mais gerais, traits descrevem características


}