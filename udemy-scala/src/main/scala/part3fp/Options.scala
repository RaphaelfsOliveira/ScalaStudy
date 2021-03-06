package part3fp

import java.util.Random

object Options extends App {

  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  println(myFirstOption)
  println(noOption)

  // unsafe APIs
  def unsafeMethod: String = null
  // val result = Some(null) // WRONG
  val result = Option(unsafeMethod) // Some or None
  println(result)

  // chained methods
  def backupMethod(): String = "Valid value"
  val chainedResult = Option(unsafeMethod).getOrElse(Option(backupMethod()))
  println(chainedResult)

  // DESING unsafe APIs
  def betterUnsafeMethod: Option[String] = None
  def betterBackupMethod: Option[String] = Some("valid result")

  val betterChainedResult = betterUnsafeMethod orElse betterBackupMethod
  println(betterChainedResult)

  // function on Options
  println(myFirstOption.isEmpty)
  println(myFirstOption.get) // UNSAFE -> DO NOT USE THIS
  println(result.getOrElse(None))

  // map, flatMap, filter
  println(myFirstOption.map(_ * 2))
  println(myFirstOption.filter(x => x > 10))
  println(myFirstOption.flatMap(x => Option(x * 10)))

  println("\n### Exercises ###")
  // Exercises
  val config: Map[String, String] = Map(
    "host" -> "176.45.36.1",
    "port" -> "80"
  )

  class Connection {
    def connect = "Connected" // connect to some server
  }

  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] = {
      if (random.nextBoolean()) Some(new Connection)
      else None
    }
  }

  val host = config.getOrElse("host", None).toString
  val port = config.getOrElse("port", None).toString

  val connection = Connection.apply(host, port)
  val connectionStatus = connection.map(c => c.connect)

  println("\n## some functions ##")
  println(connectionStatus)
  connectionStatus.foreach(println)

  println("\n## chained calls ##")
  // chained calls
  config.get("host")
    .flatMap(host => config.get("port")
      .flatMap(port => Connection(host, port))
      .map(connection => connection.connect))
    .foreach(println)

  println("\n## for-comprehensions ##")
  // for-comprehensions
  val forConnectionStatus = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield connection.connect

  forConnectionStatus.foreach(println)

}
