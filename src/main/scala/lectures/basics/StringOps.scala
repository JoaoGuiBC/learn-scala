package lectures.basics

object StringOps extends App {
  val str: String = "Olá, eu sou uma String"

  println(str.charAt(2))
  println(str.substring(7, 11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.length())
  println(str.reverse)
  println(str.take(2))

  val numberString = "2"
  val number = numberString.toInt

  println('a' +: numberString :+ 'z')

  // Especificos Scala

  // S-interpolators
  val name = "João"
  val age = 21
  val greeting = s"Olá, meu nome é $name e eu tenho $age anos"
  val anotherGreeting = s"Olá, meu nome é $name e irei fazer ${age + 1} anos"
  println(greeting)
  println(anotherGreeting)

  // F-interpolators
  val speed = 1.2f
  val myth = f"$name consegue comer $speed%2.2f fatias de pizza por minuto"
  println(myth)

  // raw-interpolator
  println("Essa é uma \n nova linha")
  println(raw"Essa é uma \n nova linha")
  val escaped = "Essa é uma \n nova linha"
  println(raw"$escaped")
}
