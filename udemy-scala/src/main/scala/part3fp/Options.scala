package part3fp

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




}
