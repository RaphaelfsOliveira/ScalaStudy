package part2oop

// alias to import some packages ( Specter => Spct )
import playground.{PinkFloyd, Specter => Spct}

import java.util.Date

// other away to import all files in package playground
// import playground._
import playground._

object PackagingAndImports extends App {

  // package members are accessible by their simple name
  val writer = new Writer("John", "Wick", 2000)
  println(writer.fullName())

  // import the package
  val testImportPackage = new Spct // playground.Specter == fully qualified name
  println(testImportPackage)

  // packages hierarchy
  // matching folder structure

  // universal package object from package object in part2oop
  testPackage
  println(SPEED_OF_LIGHT)

  // imports
  val pink = new PinkFloyd

  val date1 = new Date()
  println(date1)

}
