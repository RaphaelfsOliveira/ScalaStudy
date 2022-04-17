package part2oop


object CaseClasses extends App {

  case class Person(name: String, age: Int)

  val jack = new Person(name="Jack", age=35)

  println("### 1. class parameters are fields there is no need to use val ###")
  // 1. class parameters are fields there is no need to use val
  println(jack.name)
  println(jack.age)

  println("\n### 2. sensible toString ###")
  // 2. sensible toString
  println(jack.toString)
  println(jack)

  println("\n### 3. equals and hashCode implemented OOTB ###")
  // 3. equals and hashCode implemented OOTB
  val john = new Person(name="John", age=37)
  val jack2 = new Person(name="Jack", age=35)

  println(s"john == jack -> ${john == jack}")
  println(s"jack == jack2 -> ${jack == jack2}")

  println("\n### 4. CCs have handy copy method ###")
  // 4. CCs have handy copy method
  val jack3 = jack.copy()
  val jack4 = jack.copy(age=45) // copy receive parameters

  println(s"jack3 == jack2 -> ${jack3 == jack2}")
  println(jack4)

  println("\n### 5. CCs have companion objects ###")
  // 5. CCs have companion objects
  val thePerson = Person
  val mary = Person("Mary", 23)

  println(s"companion objects -> ${thePerson.toString}")
  println(mary.isInstanceOf[Person])
  println(mary.toString)

  println("\n### 6. CCs are serializable ###")
  // 6. CCs are serializable
  // upickle
  case class City(name: String, funActivity: String, latitude: Double)

  implicit val cityRW = upickle.default.macroRW[City]

  val bengaluru = City("Bengaluru", "South Indian food", 12.97)
  val city = upickle.default.write(bengaluru)
  println(city)

  println("\n # 6.1 deserializing case class with JSON #")
  // deserializing case class with JSON
  val jsonData = """{"name":"Barcelona","funActivity":"Eat tapas","latitude":41.39}"""
  val barcelona = upickle.default.read[City](jsonData)

  println(barcelona.isInstanceOf[City]) // City
  println(barcelona.getClass) // City
  println(s"name -> ${barcelona.name}")
  println(s"funActivity -> ${barcelona.funActivity}")
  println(s"latitude -> ${barcelona.latitude}") // 41.39

  println("\n ### 7. CCs Have extractor patters = CCs can be used in PATTERN MATCHING ###")
  // 7. CCs Have extractor patters = CCs can be used in PATTERN MATCHING
  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }
  println(UnitedKingdom.name)
  println(UnitedKingdom.toString)

}
