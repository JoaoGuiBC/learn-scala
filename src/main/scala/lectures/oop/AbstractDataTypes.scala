package lectures.oop

object AbstractDataTypes extends App {

  // abstracts
  abstract class Animal:
    val family: String
    def eat: Unit

  class Dog extends Animal:
    override val family: String = "Canidae"
    def eat: Unit = println("crunch crunch")

  // traits
  trait Carnivore:
    def eat(animal: Animal): Unit
  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded:
    val family: String = "Crocodylidae"
    def eat: Unit = println("CRUNCH")
    def eat(animal: Animal): Unit = println(
      s"estou devorando um ${animal.family}"
    )

  val dog = Dog()
  val croc = Crocodile()

  croc.eat(dog)
}

abstract class MyList:
  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(element: Int): MyList
end MyList

object EmptyList extends MyList:
  def head: Int = 0
  def tail: MyList = this
  def isEmpty: Boolean = true
  def add(element: Int): MyList = new List(element, EmptyList)
end EmptyList

class List(headValue: Int, tailValue: MyList) extends MyList:
  def head: Int = headValue
  def tail: MyList = tailValue
  def isEmpty: Boolean = false
  def add(element: Int): MyList = new List(element, this)
end List
