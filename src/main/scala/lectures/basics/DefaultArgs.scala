package lectures.basics

import scala.annotation.tailrec

object DefaultArgs extends App {
  @tailrec
  def factHelper(x: Int, accumulator: BigInt = 1): BigInt =
    if (x <= 1) accumulator
    else
      factHelper(
        x - 1,
        x * accumulator
      ) // TAIL RECURSION = usar chamada recursiva como última expressão

  println(factHelper(5000))

  def savePicture(
      format: String = "jpg",
      width: Int = 1920,
      height: Int = 1080
  ) = println("imagem salva")

  savePicture("bmp", 800)
  savePicture(height = 600)

  /*
    1 - Informar os argumentos que vem antes
    2 - Nomear os argumentos
   */

  savePicture(height = 600, format = "bmp", width = 800)
}
