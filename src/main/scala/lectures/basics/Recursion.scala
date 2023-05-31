package lectures.basics

import scala.annotation.tailrec

object Recursion extends App {
  def factorial(n: Int): Int =
    if (n <= 1) 1
    else
      println(
        "Computando o fatorial de " + n + " - Primeiramente eu preciso do fatorial de " + (n - 1)
      )
      val result = n * factorial(n - 1)
      println("Computado o valor de " + n)

      result

  println(factorial(10))
  // println(factorial(5000))

  def anotherFactorial(n: Int): BigInt =
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else
        factHelper(
          x - 1,
          x * accumulator
        ) // TAIL RECURSION = usar chamada recursiva como última expressão

    factHelper(n, 1)

  println(anotherFactorial(5000))

  // Quando precisar usar loops, use tail recursion no lugar
}
