package lectures.oop

object Objects extends App {
  // Scala não tem funcionalidades class-level ("static")
  object Person:
    // funcionalidades class-level - "static"
    val N_EYES = 2

    def canFly: Boolean = false

    // factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobby")

  class Person(val name: String):
    // funcionalidades instance-level
    println("Class Person")

  // Companions

  println(Person.N_EYES)
  println(Person.canFly)

  // Scala object = Singleton instance

  val roier = new Person("Roier")
  val jaiden = new Person("Jaiden")
  println(roier == jaiden)

  val person1 = Person
  val person2 = Person
  println(person1 == person2)

  val bobby = Person(jaiden, roier)

  /*
    Scala applications = Scala object contendo:
    def main(args: Array[String]): Unit
   */
}
