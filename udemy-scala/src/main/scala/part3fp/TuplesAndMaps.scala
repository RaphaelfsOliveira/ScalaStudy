package part3fp

object TuplesAndMaps extends App {

    // tuples 
    val aTuple = (2, "hello, Scala") // Tuple[Int, String] = (Int, String)

    println(aTuple._1)
    println(aTuple)
    println(aTuple.copy(_2 = "goodbye Java"))
    println(aTuple.toString)
    println(aTuple.swap) // ("hello Scala", 2)

    // Maps
    val aMap: Map[String, Any] = Map()

    val phonebook = Map(
        "Jim" -> 555,
        "Daniel" -> 999
    ).withDefaultValue(-1)
    println(phonebook)

    // Maps ops
    println(
        phonebook.contains("Jim")
    )
    println(phonebook("Jim"))
    println(phonebook("Mary"))

    val anotherPhoneBook = phonebook ++ Map("John" -> 777)
    println(anotherPhoneBook)


    // functionals on maps
    println(
        phonebook.map(x => x._1.toLowerCase -> x._2)
    )

    // filterKeys
    println(
        phonebook.filterKeys(x => x.startsWith("J")).toMap
    )

    // mapValues
    println(
        phonebook.mapValues(n => n * 10).toMap
    )

    println(
        phonebook.mapValues(n => "021-" + n).toMap
    )

    // conversions to other collections
    println(
        phonebook.toList
    )
    println(
        List(("Daniel", 555)).toMap
    )

    val names = List("Bob", "Ben", "James", "John", "Jim", "Mary")

    println(
        names.groupBy(name => name.charAt(0))
    )

}