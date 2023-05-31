package exercises.basics

import scala.annotation.tailrec

object Recursion extends App {
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
  def fibonacciFunction(n: Int, leftValue: BigInt = 0, rightValue: BigInt = 1): BigInt =
    if (n <= 2) leftValue + rightValue
    else fibonacciFunction(n - 1, leftValue = rightValue, leftValue + rightValue)

  println(fibonacciFunction(5000))
}
