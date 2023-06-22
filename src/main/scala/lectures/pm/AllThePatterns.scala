package lectures.pm

object AllThePatterns extends App {
  // 1 - Constants
  val x: Any = "Scala"
  val constants = x match
    case 1              => "a number"
    case "Scala"        => "The Scala"
    case true           => "The Truth"
    case AllThePatterns => "A singleton object"

  // 2   - Match anything
  // 2.1 - Wildcard
  val matchAnything = x match
    case _ =>

  // 2.2 - Variable
  val matchAVariable = x match
    case something => s"I've found $something"

  // 3 - Tuples
  val aTuple = (1, 2)
  val matchATuple = aTuple match
    case (1, 1)         =>
    case (something, 1) => s"I've found $something"

  val nestedTuple = (1, (2, 3))
  val matchNestedTuple = nestedTuple match
    case (_, (2, v)) =>

  // Pattern Matching can be nested

  // 4 - list patterns
  val aStandardList = List(1, 2, 3, 4)
  val standardListMatching = aStandardList match
    case 1 :: List(_)        => // infix pattern
    case List(1, _, _, _)    => // extractor
    case List(1, _*)         => // list of arbitrary length
    case List(1, 2, 3) :+ 42 => // infix pattern
    case List(_, _*)         =>
    case Nil                 =>

  // 5 - type specifiers
  val unknown: Any = 2
  val unknownMatch = unknown match
    case list: List[Int] => // explicit type specifier
    case _               =>

  // 6 - name binding
  val nameBindingMatch = nestedTuple match
    case (1, rest @ (2, 3))          => // name binding inside nested patterns
    case nonEmptyTuple @ (_, (2, v)) => // name binding - use the name here
    case _                           =>

  // 7 - multi-patterns
  val multiPattern = x match
    case 1 | List(1, 2) => // compound pattern (multi-pattern)
    case _              =>

  // 8 - if guards
  val secondElementSpecial = nestedTuple match
    case (_, (specialElement, _)) if specialElement % 2 == 0 =>
}
