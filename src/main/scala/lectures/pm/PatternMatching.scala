package lectures.pm

import scala.util.Random

object PatternMatching extends App {
  val random = new Random
  val x = random.nextInt(10)

  val description = x match
    case 1 => "the ONE"
    case 2 => "double or nothing"
    case 3 => "third time is the charm"
    case _ => "something else" // _ = WILDCARD

  println(x)
  println(description)

  // Decompor valores
  case class Person(name: String, age: Int)
  val bob = Person("Bob", 16)

  val greeting = bob match
    case Person(n, a) if a < 18 =>
      s"Hi, my name is $n and i can't drink in Brazil"
    case Person(n, a) => s"Hi, my name is $n and i am $a years old"

  println(greeting)

  // PM em hierarquias seladas
  sealed class Animal
  case class Dog(breed: String) extends Animal
  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("Terra Nova")
  animal match
    case Dog(someBreed) => println(s"Matched a Dog of the $someBreed breed")

  trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr

  def show(e: Expr): String = e match
    case Number(n)   => s"$n"
    case Sum(e1, e2) => s"${show(e1)} + ${show(e2)}"
    case Prod(e1, e2) =>
      def maybeShowParentheses(exp: Expr) = exp match
        case Prod(_, _) => show(exp)
        case Number(_)  => show(exp)
        case _: Expr    => s"(${show(exp)})"

      maybeShowParentheses(e1) + " * " + maybeShowParentheses(e2)

  println(show(Sum(Number(2), Number(3))))
  println(show(Sum(Sum(Number(2), Number(3)), Number(4))))
  println(show(Prod(Sum(Number(2), Number(1)), Number(3))))
  println(show(Sum(Prod(Number(1), Number(2)), Number(3))))
}
