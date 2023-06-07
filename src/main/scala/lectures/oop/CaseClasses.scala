package lectures.oop

object CaseClasses extends App:
  case class Person(name: String, age: Int)

  // 1 - parametros da classe são campos
  val john = new Person("John", 20)
  println(john.name)

  // 2 - melhor toString
  // println(instance) = println(instance.toString) / Syntactic Sugar
  println(john)

  // 3 - igual e hashCode implementados por padrão
  val john2 = new Person("John", 20)
  println(john == john2)

  // 4 - CC são mais faceis de copiar
  val john3 = john.copy(age = 45)
  println(john3)

  // 5 - CC possuem companion objects
  val thePerson = Person
  val jane = Person("Jane", 21)

  // 6 - CC são serializaveis
  // Akka

  // 7 - podem ser usados em pattern matching

end CaseClasses
