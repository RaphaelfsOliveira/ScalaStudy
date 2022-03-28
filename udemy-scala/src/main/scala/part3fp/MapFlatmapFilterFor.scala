package part3fp

object MapFlatmapFilterFor extends App {

    val list = List(1, 2, 3)
    println(list.head)
    println(list.tail)

    // map
    println(list.map(_ + 1))
    println(list.map(_ + " is a number"))

    // filter
    println(list.filter(_ % 2 == 0))

    // flatMap
    val toPair = (x: Int) => List(x, x + 1)
    println(list.flatMap(toPair))

    // print all combinations between two lists
    val numbers = List(1,2,3,4)
    val chars = List('a','b','c','d')
    val colors = List("black", "white")

    val combinations = numbers.flatMap(n => chars.map(c => "" + c + n))
    println(combinations)

    // iterarions
    val combinations2 = numbers.flatMap(n => chars.flatMap(c => colors.map(color => s"${c}_${n}_${color}")))
    println(combinations2)

    // foreach
    list.foreach(println)

    // for-comprehensions
    val forCombinations = for {
        n <- numbers
        c <- chars
        color <- colors
    } yield (s"${c}_${n}_${color}")
    
    println(forCombinations)

    // for-comprehensions with filter
    val forCombinations2 = for {
        n <- numbers if n % 2 == 0
        c <- chars
        color <- colors
    } yield (s"${c}_${n}_${color}")
    
    println(forCombinations2)

    for {
        n <- numbers
    } println(n)

    // syntax overload
    list.map { x =>
        x * 2
    }

    
}