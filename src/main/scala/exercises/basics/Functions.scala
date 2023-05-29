package exercises.basics

object Functions extends App {
  def greetingFunction(name: String, age: Int): String =
    "Olá, meu nome é " + name + " e eu tenho " + age + " anos."

  println(greetingFunction("João", 21))

  def factorialFunction(n: Int): Int =
    if (n <= 0) 1
    else n * factorialFunction(n - 1)

  println(factorialFunction(5))

  def fibonacciFunction(n: Int): Int =
    if (n <= 2) 1
    else fibonacciFunction(n - 1) + fibonacciFunction(n - 2)

  println(fibonacciFunction(5))

  def isPrimeFunction(n: Int): Boolean =
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)

    isPrimeUntil(n / 2)

  println(isPrimeFunction(13))
  println(isPrimeFunction(13 * 2))
}
