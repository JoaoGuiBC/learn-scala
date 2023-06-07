package lectures.oop

object Enums extends App:
  enum Permissions:
    case READ, WRITE, EXECUTE, NONE

    def openDocument(): Unit =
      if (this == READ) println("opening document")
      else println("reading not allowed")

  val somePermissions: Permissions = Permissions.READ

  enum PermissionsWithBits(bits: Int):
    case READ extends PermissionsWithBits(4) // 100
    case WRITE extends PermissionsWithBits(2) // 010
    case EXECUTE extends PermissionsWithBits(1) // 001
    case NONE extends PermissionsWithBits(0) // 000

  object PermissionsWithBits:
    def fromBits(bits: Int): PermissionsWithBits = PermissionsWithBits.NONE

  val somePermissionsOrdinal = somePermissions.ordinal
  val allPermissions = PermissionsWithBits.values // valores possiveis
  val readPermission: Permissions =
    Permissions.valueOf("READ") // Permission.READ
end Enums
