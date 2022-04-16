package part2oop

object Generics extends App {

    class MyList[+A] {
        // usar T para definir o tipo da lista
        // 1. Covariancia uma lista de gatos seria transformada em uma lista de animais
        def add[B >: A](element: B): MyList[B] = ???
    }

    class MyMap[String, Value]

    val listInt = new MyList[Int]
    val listString = new MyList[String]

    //    generic methods
    object MyList {
//        def empty[A]: MyList[A] = ???
    }

//    val emptyList = MyList.empty[Int]

    // variance problem
    class Animal
    class Cat extends Animal
    class Dog extends Animal

    // 1. Covariancia uma lista de gatos seria transformada em uma lista de animais
    class CovariantList[+A]
    val animal: Animal = new Cat
    val animalList: CovariantList[Animal] = new CovariantList[Cat]

    // animalList.add(new Dog) ??? HARD QUESTION
    // 2. NÃO = INVARIANCIA
    class InvariantList[A]
    val invariantList: InvariantList[Animal] = new InvariantList[Animal]

    // 3. Contravariancia
    class Trainer[-A]
    val contraVariantList: Trainer[Cat] = new Trainer[Animal]

    // Definindo TIpo e Subtipos específicos de parametros de classes
    // aqui a classe tanto pode receber uma instancia de Dog ou de Cat
    class Cage[T <: Animal](animal: T)
    val cage = new Cage(new Dog)
    val cage2 = new Cage(new Cat)

    println(cage)
    println(cage2)






}