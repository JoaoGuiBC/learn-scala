package lectures.fp

import scala.compiletime.ops.boolean

object MapFlatmapFilterFor extends App {
  val list = List(1, 2, 3)

  println(list.head)
  println(list.tail)

  // Map
  println(list.map(_ + 1))
  println(list.map(value => s"$value é um número menor que ${value + 1}"))

  // Filter
  println(list.filter(_ % 2 == 0))

  // FlatMap
  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))

  // printar todas as combinações entre três listas
  val numbers = List(1, 2, 3, 4)
  val chars = List('A', 'B', 'C', 'D')
  val colors = List("black", "white")

  // "iterating"
  val result = chars.flatMap(char =>
    numbers.flatMap(number => colors.map(color => s"$char$number - $color"))
  )
  println(result)

  // Foreach
  list.foreach(println)

  // for-comprehensions
  val forResult = for
    char <- chars
    number <- numbers if number % 2 == 0
    color <- colors
  yield s"$char$number - $color"

  println(forResult)

  for number <- numbers do println(number)

  // syntax overload
  list.map { x =>
    x * 2
  }

  abstract class Maybe[+T]:
    def map[B](f: T => B): Maybe[B]
    def flatMap[B](f: T => Maybe[B]): Maybe[B]
    def filter(p: T => Boolean): Maybe[T]

  case object MaybeNot extends Maybe[Nothing]:
    def map[B](f: Nothing => B): Maybe[B] = MaybeNot
    def flatMap[B](f: Nothing => Maybe[B]): Maybe[B] = MaybeNot
    def filter(p: Nothing => Boolean): Maybe[Nothing] = MaybeNot

  case class Just[+T](value: T) extends Maybe[T]:
    def map[B](f: T => B): Maybe[B] = Just(f(value))
    def flatMap[B](f: T => Maybe[B]): Maybe[B] = f(value)
    def filter(p: T => Boolean): Maybe[T] = if p(value) then this else MaybeNot

  val just3 = Just(3)
  println(just3)
  println(just3.map(_ * 2))
  println(just3.flatMap(x => Just(x % 2 == 0)))
  println(just3.filter(_ % 2 == 0))
}
