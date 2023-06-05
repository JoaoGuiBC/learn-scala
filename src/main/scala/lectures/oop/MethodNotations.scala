package lectures.oop

object MethodNotations extends App {
  class Person(val name: String, favoriteMovie: String, val age: Int):
    def likes(movie: String): Boolean = movie == favoriteMovie

    def +(nickname: String): Person =
      new Person(s"$name ($nickname)", this.favoriteMovie, this.age)
    def +(person: Person): String =
      s"${this.name} está saindo com ${person.name}"

    def unary_! : String = s"$name, que isso?!"
    def unary_+ : Person =
      new Person(this.name, this.favoriteMovie, this.age + 1)

    def apply(): String = s"Olá, meu nome é $name e eu gosto de $favoriteMovie"
    def apply(quantity: Int): String =
      s"$name viu $favoriteMovie $quantity vezes"

  val jane = new Person("Jane", "Movie1", 19)
  println(jane.likes("Movie1"))
  println(jane likes "Movie1") // equivalente
  // infix notation = operator notation (syntactic sugar)

  // "operadores" em scala
  val john = new Person("John", "Movie2", 18)
  println(jane + john)
  println(jane.+(john))

  println(1 + 2)
  println(1.+(2))

  // Todo operador é um metodo

  // prefix notation
  val x = -1 // equivalente a 1.unary_-
  val y = 1.unary_-
  // unary_ prefix só funciona com - + ~ !

  println(!jane)
  println(jane.unary_!)

  // apply
  println(jane.apply())
  println(jane()) // equivalente

  val nickname = jane + "cinéfila"
  println(nickname.name)

  val aged = +jane
  println(aged.age)

  println(jane(2))
}
