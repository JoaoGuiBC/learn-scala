package lectures.basics

object ValuesVariablesTypes extends App {
  val x: Int = 42

  // val é imutavel
  // Compiler consegue inferir typagem

  val aString: String = "Hello"
  val anotherString = "goodbye" 

  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 12345
  val aLong: Long = 12345678912l
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  // Variaveis
  var aVariable: Int = 4
  aVariable = 5
}
