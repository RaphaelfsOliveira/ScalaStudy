package part2oop

object Generics extends App {

    class MyList[T] {
//        usar T para definir o tipo da lista
    }

    class MyMap[String, Value]

    val listInt = new MyList[Int]
    val listString = new MyList[String]

    //    generic methods
    object MyList {
        def empty[A]: MyList[A] = ???

    }

}