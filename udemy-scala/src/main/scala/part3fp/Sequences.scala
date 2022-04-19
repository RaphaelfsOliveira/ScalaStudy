package part3fp

import scala.util.Random

object Sequences extends App {

  println("### Seq ###")
  // Seq
  val aSequence = Seq(1, 2, 3, 4)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(5, 6, 7))

  val aSequence2 = aSequence.+:(7)
  println(aSequence2.sorted)

  println("\n### Ranges ###")
  // Ranges
  val aRange: Seq[Int] = 1 to 10
  aRange.foreach(println)

  val aRange2: Seq[Int] = 1 until 5
  aRange2.foreach(println)

  (1 until 5).foreach(_ => println("Scala"))

  println("\n### Lists ###")
  // Lists
  val aList = List(1, 2, 3)
  val prepended = 42 :: aList
  val prepended2 =  42 +: aList :+ 89

  println(prepended)
  println(prepended2)

  val apples5 = List.fill(5)("apple")
  println(apples5)

  println(aList.mkString("|"))
  println(apples5.mkString("_"))

  println("\n### Arrays ###")
  // Arrays
  val numbers = Array(1, 2, 3, 4)
  println(numbers.mkString(", "))

  // criou um array com espaço para tres elementos String
  val threeElements = Array.ofDim[String](3)

  threeElements.foreach(println) //

  // mutation
  numbers(2) = 0 // atualizou o elemento de index 2 para zero no array existente
  println(numbers.mkString(", "))

  println("\n### Arrays and Seq ###")
  // arrays and seq
  val numbersSeq: Seq[Int] = numbers // implicit conversion
  println(numbersSeq)

  println("\n### Vectors ###")
  // Vectors
  val vector: Vector[Int] = Vector(1, 2, 3)
  println(vector)

  println("\n### Vectors vs Lists ###")
  // Vectors vs Lists

  val maxRuns = 1000
  val maxCapacity = 1000000

  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random

    val times = for {
      i <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }

    times.sum * 1.0 / maxRuns
  }

  val numberList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  // keeps reference to tail
  // updating an element in the middle takes long
  println(getWriteTime(numberList))

  // depth of the tree is small
  // needs to replace an entire 32-element chunk
  println(getWriteTime(numbersVector))

}
