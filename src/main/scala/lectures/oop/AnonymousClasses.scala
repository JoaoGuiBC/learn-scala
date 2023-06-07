package lectures.oop

object AnonymousClasses extends App:
  abstract class Animal:
    def eat: Unit

  val funnyAnimal: Animal = new Animal:
    override def eat: Unit = println("Im funny")
  /*
    EQUIVALENTE A:

    class AnonymousClasses$$anon$1 extends Animal:
      override def eat: Unit = println("Im funny")

    val funnyAnimal: Animal = new AnonymousClasses$$anon$1
   */

  println(funnyAnimal.getClass())

  class Person(name: String):
    def sayHi: Unit = println(s"HI, my name is $name")

  val john = new Person("John"):
    override def sayHi: Unit = println("Hi, my name is John")
end AnonymousClasses
