package lectures.pm

object PatternsEverywhere extends App {
  try
    // code
    catch
      case e: RuntimeException => "Runtime"
      case npe: NullPointerException => "npe"
      case _ => "something else"

  // catches are actually matches
  /*
    try
      // code
      catch (e)
        e match
          case e: RuntimeException => "Runtime"
          case npe: NullPointerException => "npe"
          case _ => "something else"
  */

  val list = List(1,2,3,4)
  val evenOnes = for
    x <- list if x % 2 == 0
  yield 10 * x

  // generators are pattern matching
  val tuples = List((1,2), (3,4))
  val filterTuples = for
    (first, second) <- tuples
  yield first * second
  // case classes, :: operators, ...

  val tuple = (1,2,3)
  val (a, b, c) = tuple

  println(b)
  // multiple value definitions based on pattern matching

  val head :: tail = list

  println(head)
  println(tail)

  // partial function based on pattern matching
  val mappedList = list.map {
    case v if v % 2 == 0 => v + " is even"
    case 1 => "is the ONE"
    case _ => "something else"
  } // partial function literal

  // equivalent
  val mappedList2 = list.map(x => x match
    case v if v % 2 == 0 => v + " is even"
    case 1 => "is the ONE"
    case _ => "something else"
  )
    
}
