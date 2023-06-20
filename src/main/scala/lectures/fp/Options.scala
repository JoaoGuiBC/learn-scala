package lectures.fp

import scala.util.Random

object Options extends App {
  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  println(myFirstOption)
  println(noOption)

  // TRABALHAR com unsafe APIs
  def unsafeMethod(): String = null
  // val result = Some(unsafeMethod) // ERRADO
  val result = Option(unsafeMethod()) // Some ou None

  println(result)

  // chained methods
  def backupMethod(): String = "A valid result"
  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))

  println(chainedResult)

  // PLANEJAR unsafe APIs
  def betterUnsafeMethod(): Option[String] = None
  def betterBackupMethod(): Option[String] = Some("A valid result")
  val betterChainedResult = betterUnsafeMethod() orElse betterBackupMethod()

  println(betterChainedResult)

  // funções em Options
  println(myFirstOption.isEmpty)
  println(myFirstOption.get) // NÃO SEGURO - NÃO USE ISSO

  // map, flatMap, filter
  println(myFirstOption.map(_ * 2))
  println(myFirstOption.filter(x => x > 10))
  println(myFirstOption.flatMap(x => Option(x * 10)))

  val config: Map[String, String] = Map("host" -> "176.45.36.1", "port" -> "80")

  class Connection:
    def connect = "Connect"

  object Connection:
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] =
      if (random.nextBoolean()) Some(new Connection)
      else None

  val host = config.get("host")
  val port = config.get("port")

  val connection = host.flatMap(h => port.flatMap(p => Connection.apply(h, p)))
  val connectionStatus = connection.map(c => c.connect)

  println(connectionStatus)
  connectionStatus.foreach(println)

  println("chained call")
  config
    .get("host")
    .flatMap(host =>
      config
        .get("port")
        .flatMap(port => Connection(host, port))
        .map(_.connect)
    )
    .foreach(println)

  println("for-comprehension")
  val forConnect = for
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  yield connection.connect

  forConnect.foreach(println)

}
