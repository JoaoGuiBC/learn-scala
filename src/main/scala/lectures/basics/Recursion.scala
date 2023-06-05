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

  @tailrec
  def concatenateString(
      n: Int,
      aString: String,
      accumulator: String = ""
  ): String =
    if (n == 0) accumulator
    else concatenateString(n - 1, aString, accumulator + aString)

  println(concatenateString(5000, "Hello"))

  def isPrime(n: Int): Boolean =
    @tailrec
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)

    isPrimeUntil(n / 2)

  println(isPrime(13))
  println(isPrime(13 * 2000000))

  @tailrec
  def fibonacciFunction(
      n: Int,
      leftValue: BigInt = 0,
      rightValue: BigInt = 1
  ): BigInt =
    if (n <= 2) leftValue + rightValue
    else
      fibonacciFunction(n - 1, leftValue = rightValue, leftValue + rightValue)

  println(fibonacciFunction(5000))
}
