package part3fp

import scala.util.{Failure, Random, Success, Try}

object HandlingFailure extends App {

  // create success and failure
  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("Fail"))

  println(aFailure)
  println(aFailure)

  // Try objects via the apply method
  def unsafeMethod: String = throw new RuntimeException("NO String FOR YOU")

  val potentialFailure = Try(unsafeMethod)
  println(potentialFailure)

  // syntax sugar
  val anotherPotentialFailure = Try {
    // code that might throw
  }

  // utitlities
  println(potentialFailure.isSuccess)

  // ofElse
  def backupMethod: String = "a valid result"
  val fallBackTry = Try(unsafeMethod).orElse(Try(backupMethod))
  println(fallBackTry)

  // IF you design the API
  def betterUnsafeMethod: Try[String] = Failure(new RuntimeException)
  def betterBackupMethod: Try[String] = Success("a valid result 2 ##")

  val betterFallBack = betterUnsafeMethod orElse betterBackupMethod
  println(betterFallBack)

  // map, flatMap, filter
  println(aSuccess.map(_ * 2))
  println(aSuccess.flatMap(x => Success(x * 10)))
  println(aSuccess.filter(_ > 2))

  // for-comprehensions
  println("\n## Exercises")

  val hostname = "hostname"
  val port = "8080"
  def renderHTML(page: String): Unit = println(page)

  class Connection {
    def get(url: String): String = {
      val random = new Random(System.nanoTime())

      if (random.nextBoolean()) "<html>...</html>"
      else throw new RuntimeException("Connection interrupted")
    }

    def getSafe(url: String): Try[String] = Try(get(url))
  }

  object HttpService {
    val random = new Random(System.nanoTime())

    def getConnection(host: String, port: String): Connection = {
      if (random.nextBoolean()) new Connection
      else throw new RuntimeException("Someone else took the port")
    }

    def getSafeConnection(host: String, port: String): Try[Connection] = Try(getConnection(host, port))
  }

  val possibleConnection = HttpService.getSafeConnection(hostname, port)
  val possibleHTML = possibleConnection.flatMap(connection => connection.getSafe("/home"))
  possibleHTML.foreach(renderHTML)

  // shorthand version
  HttpService.getSafeConnection(hostname, port)
    .flatMap(connection => connection.getSafe("/home"))
    .foreach(renderHTML)

}