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
}
