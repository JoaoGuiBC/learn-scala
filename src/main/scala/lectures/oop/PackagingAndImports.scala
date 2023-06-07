package lectures.oop

import playground.{Tomie, JuniIto => Author}

import java.util.Date
import java.sql.{Date => SqlDate}

object PackagingAndImports extends App:
  // É possivel acessar os membros do mesmo pacote simplesmente pelo nome
  val writer = new Writer("John", "Doe", 2000)

  // Caso contrario é preciso importar o pacote
  val book1 = new Tomie
  val book2 = new playground.Tomie

  // package object
  sayHello
  println(SPEED_OF_LIGHT)

  // Imports
  val author = new Author

  val date = new Date
  val sqlDate = new SqlDate(2020, 0, 2)

  /*
    default imports
      java.lang - String, Object, Exception
      scala - Int, Nothing, Function
      scala.Predef - println, ???
   */
end PackagingAndImports
