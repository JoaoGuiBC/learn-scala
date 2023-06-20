package lectures.fp

import scala.util.{Success, Failure, Try, Random}

object HandlingFailure extends App {
  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("Failed"))

  println(aSuccess)
  println(aFailure)

  def unsafeMethod(): String = throw new RuntimeException("Fail")

  // Try objects
  val potentialFailure = Try(unsafeMethod())
  println(potentialFailure)

  // Syntax sugar
  val anotherPotentialFailure = Try {
    unsafeMethod()
  }

  // Utils
  println(potentialFailure.isSuccess)

  // orElse
  def backupMethod(): String = "A valid result"
  val fallbackTry = Try(unsafeMethod()).orElse(Try(backupMethod()))

  println(fallbackTry)

  // Se você está criando uma API
  def betterUnsafeMethod(): Try[String] = Failure(new RuntimeException)
  def betterBackupMethod(): Try[String] = Success("A valid result")
  val betterFallback = betterUnsafeMethod() orElse betterBackupMethod()

  println(betterFallback)

  // map, flatMap, filter
  println(aSuccess.map(_ * 2))
  println(aSuccess.flatMap(x => Success(x * 10)))
  println(aSuccess.filter(_ > 10))

  // for-comprehension
  val hostname = "localhost"
  val port = "3333"
  def renderHTML(page: String) = println(page)

  class Connection:
    def get(url: String): String =
      val random = new Random(System.nanoTime())
      if (random.nextBoolean()) "<html>...</html>"
      else throw new RuntimeException("Connection interrupted")

  object HttpService:
    val random = new Random(System.nanoTime())

    def getConnection(host: String, port: String): Connection =
      if (random.nextBoolean()) new Connection
      else throw new RuntimeException("Port already in use")

  // se conseguir a pagina http printar o renderHTML
  for
    connection <- Try(HttpService.getConnection(hostname, port))
    page <- Try(connection.get("url"))
  yield renderHTML(page)
}
