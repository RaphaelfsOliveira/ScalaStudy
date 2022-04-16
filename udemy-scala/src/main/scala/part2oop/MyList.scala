package part2oop

abstract class MyList {
    def head: Any
    def tail: MyList
    def isEmpty: Boolean
    def add(element: Any): MyList
    def printElements: String

    // chamada polimorfica
    override def toString: String = s"[${printElements}]"
}

object Empty extends MyList {
    def head: Any = throw new NoSuchElementException
    def tail: MyList = throw new NoSuchElementException
    def isEmpty: Boolean = true
    def add(element: Any): MyList = new Cons(element, Empty)
    def printElements: String = "[]"
}

class Cons(h: Any, t: MyList) extends MyList {
    def head: Any = h
    def tail: MyList = t
    def isEmpty: Boolean = false
    def add(element: Any): MyList = new Cons(element, this)
    def printElements: String = {
        if (t.isEmpty) "" + h
        else h + ", " + t.printElements
    }
}

object ListTest extends App {
    val list = new Cons("t", Empty)
    println(list.head)
    println(list.toString)

    val list2 = list.add(1)
    val list3 = list2.add("test")
    val list4 = list3.add(0.007)

    println(list4.toString)
}