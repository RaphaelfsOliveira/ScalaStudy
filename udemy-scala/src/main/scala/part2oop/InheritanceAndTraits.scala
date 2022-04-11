package part2oop

object InheritanceAndTraits extends App {

    // (sealed) only extends class in this file
    sealed class Animal {
        val creatureType: String = "wild"
        
        def eat = println("nomnom")

        final def talk = println("who!")

        // private: use only in this class
        private def walk = println("walking")

        // protected: use in this class inside subclass
        protected def sleep = println("sleeping")
    }

    class Cat extends Animal {
        
        def doSomething = {
            // access only where because is protected from class Animal
            sleep
            println("doing")
        }
    }

    val cat = new Cat
    cat.eat
    cat.doSomething

    // constructors
    class Person(name: String, age: Int) {
        
        // constructor
        def this(name: String) = this(name, 0)
    }
    class Adult(name: String, age: Int, idCard: String) extends Person(name)

    // overriding
    class Dog extends Animal {
        override val creatureType = "domestic"
        override def eat = println("crunch, crunch")
    }

    class Tiger(override val creatureType: String) extends Animal {
        // override value from class Animal from args in constructor

        override def eat = {
            // super call methods from class Animal
            super.eat
            println("arg arg")
        }
    }

    val dog = new Dog
    dog.eat
    println(dog.creatureType)

    val tiger = new Tiger("Wild and free")
    println(tiger.creatureType)

    // type substituition (polymorphism)
    val unknownAnimal: Animal = new Tiger("Wild and other things")
    unknownAnimal.eat
    unknownAnimal.talk

    // overRIDING VS overLOADING

    // preventing overrides
    // 1 - use final on member
    // 2 - user final on class
    // 3 - seal the class (sealed)


}