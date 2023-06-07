package lectures.oop

object Generics extends App:
  class MyList[A]
  class MyMap[Key, Value]

  val listOfInts = new MyList[Int]
  val listOfStrings = new MyList[String]

  object MyList:
    def empty[A]: MyList[A] = new MyList[A]

  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  val animal: Animal = new Cat

  // 1 - COVARIANCE
  class CovariantList[+A]
  val covariantAnimalList: CovariantList[Animal] = new CovariantList[Cat]
  // covariantAnimalList.add(new Dog)

  // 2 - INVARIANCE
  class InvariantList[A]
  val invariantList: InvariantList[Animal] = new InvariantList[Animal]

  // 3 - CONTRAVARIANCE
  class ContravarianceList[-A]
  val contravarianceList: ContravarianceList[Cat] =
    new ContravarianceList[Animal]

  // bounded types
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)

  /* ERRO
    class Car
    val newCage = new Cage(new Car)
   */
end Generics
