package lectures.oop

object OOBasics extends App {
  val john = Person("John", 26)
  println(john.age)
  john.greet("Jane")
  john.greet()

  val writer = Writer("John", "Doe", 2000)
  val novel = Novel("Livro", 2018, writer)

  println(writer.fullname())
  println(novel.authorAge())
  println(novel.isWrittenBy("Jane Doe"))
  println(novel.isWrittenBy("John Doe"))

  val newEdition = novel.copy(2020)
  println(newEdition.authorAge())

  val counter = Counter(1)
  println(counter.currentCount())

  val increment = counter.increment()
  println(increment.currentCount())

  val incrementMultiple = increment.increment(10)
  println(incrementMultiple.currentCount())

  val decrement = incrementMultiple.decrement()
  println(decrement.currentCount())

  val decrementMultiple = decrement.decrement(5)
  println(decrementMultiple.currentCount())
}

class Person(name: String, val age: Int):
  def greet(name: String): Unit = println(s"${this.name} diz: Olá, $name")

  // overloading
  def greet(): Unit = println(s"Olá, me chamo $name")

class Writer(firstName: String, surname: String, val birthYear: Int):
  def fullname(): String = s"$firstName $surname"

class Novel(name: String, yearOfRelease: Int, author: Writer):
  def authorAge(): Int = yearOfRelease - author.birthYear

  def isWrittenBy(name: String): Boolean = name == author.fullname()

  def copy(newYearOfRelease: Int): Novel =
    Novel(name, newYearOfRelease, author)

class Counter(value: Int):
  def currentCount(): Int = value

  def increment(): Counter = Counter(value + 1)
  def decrement(): Counter = Counter(value - 1)

  def increment(value: Int): Counter = Counter(this.value + value)
  def decrement(value: Int): Counter = Counter(this.value - value)
