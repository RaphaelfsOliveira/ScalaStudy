package part2oop

object CaseClasses extends App {

  case class Person(name: String, age: Int)

  val jack = new Person(name="Jack", age=35)

  // 1. class parameters are fields there is no need to use val
  println(jack.name)
  println(jack.age)

  // 2. sensible toString
  println(jack.toString)
  println(jack)

  // 3. equals and hashCode implemented OOTB
  val john = new Person(name="John", age=37)
  val jack2 = new Person(name="Jack", age=35)

  println(s"john == jack -> ${john == jack}")
  println(s"jack == jack2 -> ${jack == jack2}")

  // 4. CCs have handy copy method
  val jack3 = jack.copy()
  val jack4 = jack.copy(age=45) // copy receive parameters

  println(s"jack3 == jack2 -> ${jack3 == jack2}")
  println(jack4)

  // 5. CCs have companion objects
  val thePerson = Person
  val mary = Person("Mary", 23)

  println(s"companion objects -> ${thePerson.toString}")
  println(mary.isInstanceOf[Person])

  println(mary.toString)

}
