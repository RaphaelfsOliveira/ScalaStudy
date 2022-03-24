package part2oop

import java.security.Permission

object Enums {

    enum Permissions {
        case READ, WRITE, EXECUTE, NONE

        def openDocument(): Unit = {
            if (this == READ) println("opening document...")
        }
    }

    val somePermissions: Permission = Permissions.READ

    enum PermissionsWithBits(bits: Int) {
        case READ extends PermissionsWithBits(4)
        case WRITE extends PermissionsWithBits(2)
        case EXECUTE extends PermissionsWithBits(1)
        case NONE extends PermissionsWithBits(0)
    }

    object PermissionsWithBits {
        def fromBits(bits: Int): PermissionsWithBits = {
            PermissionsWithBits.NONE
        }
    }

    // standart API 
    val somePermissionsOrdinal = somePermissions.ordinal

    def main(args: Array[String]): Unit = {
        somePermissions.openDocument()
    }  
}
