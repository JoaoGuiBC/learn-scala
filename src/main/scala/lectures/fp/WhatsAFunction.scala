package lectures.fp

object WhatsAFunction extends App:
// OBJETIVO: Usar funções como elementos firts class
// PROBLEMA: OOP

  val doubler = new MyFunction[Int, Int]:
    override def apply(element: Int): Int = element * 2

  println(doubler(2))

  val stringToIntConverter = new Function1[String, Int]:
    override def apply(string: String): Int = string.toInt

  println(stringToIntConverter("5") + 5)

  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int]:
    override def apply(v1: Int, v2: Int): Int = v1 + v2

  println(adder(1, 2))

  // Tipagem de função = Function2[A, B, C] === (A,B) => C

  // TODAS AS FUNÇÕES EM SCALA SÃO OBJETOS

  /*
  1 - concatena duas strings
  2 - funcção que recebe um Int e retorna uma função que recebe um Int e retorna um Int

   */

  val stringAdder: ((String, String) => String) =
    new Function2[String, String, String]:
      override def apply(v1: String, v2: String): String = v1 + v2

  println(stringAdder("Hello ", "World"))

  val function: Function1[Int, Function1[Int, Int]] =
    new Function1[Int, Function1[Int, Int]]:
      override def apply(v1: Int): Function1[Int, Int] =
        new Function1[Int, Int]:
          override def apply(v2: Int): Int = v1 + v2

  val superAdder = function(30)
  println(superAdder(5))
  println(function(5)(5))
end WhatsAFunction

trait MyFunction[A, B]:
  def apply(element: A): B
