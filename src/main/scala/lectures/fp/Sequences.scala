package lectures.fp

import lectures.basics.StringOps.number
import java.util.Random

object Sequences extends App {
  // Seq
  val aSequence = Seq(1,3,2,4)
  val list = List(1,2,3,4)
  
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(5,6,7))
  println(aSequence.sorted)

  // Ranges
  val aRange1: Seq[Int] = 1 to 10
  val aRange2: Seq[Int] = 1 until 10
  aRange1.foreach(println)
  aRange2.foreach(println)

  (1 to 5).foreach(x => println("Hello"))

  // Lists
  val aList = List(1,2,3)
  val prepended = 42 +: aList :+ 50
  println(prepended)

  val apples5 = List.fill(5)("apple")
  println(apples5)
  println(aList.mkString(" -|- "))

  // arrays
  val aArray = Array(1,2,3,4)
  val threeElements = Array.ofDim[Int](3)

  println(aArray)
  println(threeElements)
  threeElements.foreach(println)

  // mutation
  aArray(2) = 0
  println(aArray.mkString(" "))

  // Arrays e Seq
  val aArraySeq: Seq[Int] = aArray // conversão implicita
  println(aArraySeq)

  // Vectors
  val aVector: Vector[Int] = Vector(1,2,3)
  println(aVector)

  // vetores vs lists

  val maxRuns = 1000
  val maxCapacity = 1000000

  def getWriteTime(collection: Seq[Int]): Double =
    val r = new Random
    val times = for
      it <- 1 to maxRuns
    yield
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    
    times.sum * 1.0 / maxRuns

  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  println(getWriteTime(numbersList))
  println(getWriteTime(numbersVector))
}
