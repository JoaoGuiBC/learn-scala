package lectures.fp

object HOFsCurries extends App:
  // val superFunction : (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = ???
  // High Order Function (HOF)

  // Map, FlatMap, Filter

  // Função que executa uma função n vezes em cima de um valor x
  // nTime(f, n, x) 
  // nTime(f, n, x) = f(f(f(x))) = nTimes(f, 2, f(x)) = f(f(f(x)))
  // nTimes(f, n, x) = f(f(...f(x))) = nTimes(f, n-1, f(x))
  def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if (n <= 0) x
    else nTimes(f, n-1, f(x))

  val plusOne = (x: Int) => x + 1
  println(nTimes(plusOne, 5, 1))

  // bNT(f, n) = x = => f(f(...f(x)))
  // increment5 = bNT(plusOne, 5) = x => plusOne(plusOne(...plusOne(x)))
  // val y = increment5(1)
  def betterNTimes(f: Int => Int, n: Int): (Int => Int) =
    if (n <= 0) (x: Int) => x
    else (x: Int) => betterNTimes(f, n-1)(f(x))

  val plus10 = betterNTimes(plusOne, 10)
  println(plus10(1))

  // curried functions
  val superAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
  val add3 = superAdder(3)

  println(add3(10))
  println(superAdder(3)(10))

  // funções com multipla lista de parametros
  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  val standardFormat: (Double => String) = curriedFormatter("%4.2f")
  val preciseFormat: (Double => String) = curriedFormatter("%10.8f")

  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))

end HOFsCurries