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
        "Daniel" -> 999,
        ("JIM", 900),
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
        "toLowerCase -> ",
        phonebook.map(x => x._1.toLowerCase -> x._2)
    )

    // filterKeys
    println(
        "filterKeys -> ",
        phonebook.filterKeys(x => x.startsWith("J")).toMap
    )

    // mapValues
    println(
        "mapValues -> ",
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

    val testJson = Map(
        "test1" -> List("x", "y", "z"),
        "test1" -> List("1", "2", "3")
    )

    println(
        names.groupBy(name => name.charAt(0))
    )

    // Exercises
    println("\n### Exercises")

    def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
        network + (person -> Set())
    }

    def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
        val friendsA = network(a)
        val friendsB = network(b)

        network + (a -> (friendsA + b)) + (b -> (friendsB + a))
    }

    def unfriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
        val friendsA = network(a)
        val friendsB = network(b)

        network + (a -> (friendsA - b)) + (b -> (friendsB - a))
    }

    def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {

        def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] = {
            if (friends.isEmpty) networkAcc
            else removeAux(friends.tail, unfriend(networkAcc, person, friends.head))
        }

        val unfriended = removeAux(network(person), network)
        unfriended - person
    }

    def nFriends(network: Map[String, Set[String]], person: String): Int = {
        if (!network.contains(person)) 0
        else network(person).size
    }

    def mostFriends(network: Map[String, Set[String]]): String = {
        network.maxBy(pair => pair._2.size)._1
    }

    def nPeopleWithNoFriends(network: Map[String, Set[String]]): Int = {
        network.count(_._2.isEmpty)
    }

    def socialConnections(network: Map[String, Set[String]], a: String, b: String): Boolean = {
        val net1 = network(a)
        val net2 = network(b)

        val relFriendA = net1.flatMap(x => network(x)).contains(a)
        val relFriendB = net2.flatMap(x => network(x)).contains(b)

        val result: Boolean = relFriendA && relFriendB
        result
    }

    val empty: Map[String, Set[String]] = Map()
    val network = add(add(empty, "Bob"), "Mary")

    println(network)
    println(friend(network, "Bob", "Mary"))
    println(unfriend(friend(network, "Bob", "Mary"), "Bob", "Mary"))
    println(remove(friend(network, "Bob", "Mary"), "Bob"))

    // Jim, Bob, Mary
    val people = add(add(add(add(add(empty, "Bob"), "Mary"), "Jim"), "Jack"), "Martha")
    val net1 = friend(people, "Bob", "Jim")
    val net11 = friend(net1, "Bob", "Mary")
    val net2 = friend(net11, "Jack", "Mary")

    println(net2)
    println(nFriends(net2, "Bob"))
    println(nFriends(net2, "John"))

    println(mostFriends(net2))
    println(nPeopleWithNoFriends(net2))
    println(socialConnections(net2, "Bob", "Jim"))
    println(socialConnections(net2, "Jack", "Jim"))
    println(socialConnections(net2, "Martha", "Jim"))

}