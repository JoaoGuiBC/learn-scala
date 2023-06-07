package lectures.oop

object Exceptions extends App:
  val x: String = null
  // println(x.length)
  // ^^ vai crashar com um Null Pointer Exception

  // throw new NullPointerException

  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No Int for you!")
    else 42

  val potentialFail =
    try getInt(true)
    catch case e: RuntimeException => 24
    finally
      // Vai executar SEMPRE
      // Opcional
      // Não influencia no tipo retornado por essa expressão
      // Usar finally apenas para Side Effects
      println("Finally")

  println(potentialFail)

  class MyException(val message: String) extends Exception
  val exception = new MyException("Erro")

  try throw new MyException("Erro ao executar")
  catch case e: MyException => println(e.message)

end Exceptions
