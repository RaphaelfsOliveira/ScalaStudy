package part2oop

object Enums extends App {

  object Permissions extends Enumeration {
    type Permissions = Value

    val READ, WRITE, EXECUTE, NONE = Value
  }

  case class Permissions(permissions: Permissions.Value) {
    // add fields/ methods
    def openDocument(): Unit = {
      if (this.permissions == Permissions.READ) println("Opening document")
      else println("reading not allowed")
    }

  }

  val somePermissions: Permissions.Value = Permissions.READ
  println(somePermissions)
  println(Permissions.values)

  val perm = new Permissions(somePermissions)
  perm.openDocument()

  println("\nforeach permissions")
  Permissions.values foreach println

}
