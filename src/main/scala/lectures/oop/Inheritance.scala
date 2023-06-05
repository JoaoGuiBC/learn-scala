package lectures.oop

object Inheritance extends App {

  // Single class inheritance
  sealed class Animal:
    val family = "Felidae"
    protected def eat = println("nhom")

  class Cat extends Animal:
    def crunch =
      eat
      println("crunch crunch")

  val cat = Cat()
  cat.crunch
  println(cat.family)

  // constructors
  class Person(name: String, age: Int)
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  // overriding
  class Dog extends Animal:
    override val family = "Canidae"
    override def eat =
      super.eat
      println("crunch crunch")

  val dog = Dog()
  dog.eat
  println(dog.family)

  /*
    impedindo overrides
    1 - usar final no membro
    2 - usar final na classe inteira
    3 - selar a classe = permite a classe ser extendida nesse arquivo mas não em outros
   */
}
