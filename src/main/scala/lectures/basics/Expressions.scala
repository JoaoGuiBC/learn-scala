package lectures.basics

object Expressions extends App {
  val x = 1 + 2 // Expression

  println(x)
  println(2 + 3 * 4)
  // + - * / & | ^ << >> >>> (right shift with zero extension)

  println(x == 1)
  // == != > >= < <=

  println(!(x == 1))
  // ! && ||

  var aVariable = 2
  aVariable += 3 // -= *= /=
  println(aVariable)

  // Instructions (DO) vs Expressions (VALUE)

  // IF
  val aCondition = true
  val aConditionedValue = if (aCondition) 5 else 3
  println(aConditionedValue)

  var i = 0
  while (i < 10)
    println(i)
    i += 1

  // Evitar ao maximo o uso de loops
  // Em Scala tudo é expression

  val aWeirdValue = (aVariable = 3) // Unit === void
  println(aWeirdValue)

  // Side Effects: println(), while, reassigning

  // Code blocks
  val aCodeBlock =
    val y = 2
    val z = y + 1

    if (z > 2) "Hello" else "goodbye"

}
