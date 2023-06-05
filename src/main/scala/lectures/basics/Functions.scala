package lectures.basics

object Functions extends App {
  def aFunction(a: String, b: Int): String =
    a + " " + b

  println(aFunction("Hello", 3))

  def aRepeatedFunction(aString: String, n: Int): String =
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)

  println(aRepeatedFunction("Hello", 5))

  // Quando precisar usar loops, usar recursividade no lugar

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)
  aFunctionWithSideEffects("Hello side effects")

  def aBigFunction(n: Int): Int =
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n - 1)

  println(aBigFunction(2))

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
