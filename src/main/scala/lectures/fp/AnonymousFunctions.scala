package lectures.fp

object AnonymousFunctions extends App:
  // Função anonima (LAMBDA)
  val doubler = (x: Int) => x * 2

  // multiplo parametro em uma lambda
  val adder = (a: Int, b: Int) => a + b

  // Sem parametros
  val justDoSomething = () => 3

  // Atenção
  println(justDoSomething) // A propria função
  println(justDoSomething()) // A chamada

  val niceIncrementer: Int => Int = _ + 1 // Equivalente a x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ // Equivalente a (a, b) => a + b

  val function = (value1: Int) => (value2: Int) => value1 + value2
  val superAdder = function(30)

  println(superAdder(4))

end AnonymousFunctions
