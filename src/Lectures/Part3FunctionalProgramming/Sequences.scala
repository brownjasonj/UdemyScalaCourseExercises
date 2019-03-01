package Lectures.Part3FunctionalProgramming

import java.util.Random

object Sequences extends App {


  // Sequences
  val aSequence = Seq(2, 4, 1, 3)

  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(5,6,7))
  println(aSequence.sorted)

  // Ranges
  val aRange: Seq[Int] = 1 to 10
  aRange.foreach(println)

  (1 to 10).foreach(x => println("hello"))

  // lists
  val aList = List(1, 2, 3)
  val prepended = 42 +: aList :+ 9
  println(prepended)

  val apples5 = List.fill(5)("apple")
  println(apples5)
  println(apples5.mkString("-|-"))

  // arrays
  val numbers = Array(1, 2, 3, 4)
  val threeElements = Array.ofDim[Int](3)
  println(threeElements)
  threeElements.foreach(println)

  // mutations
  println(numbers.mkString(""))
  numbers(2) = 0  // syntax sugar for numbers.update(2,0)
  println(numbers.mkString(""))

  // arrays and seq
  val numbersSeq: Seq[Int] = numbers    // implicit conversions
  println(numbersSeq)

  // vectors
  val vector: Vector[Int] = Vector(1,2,3)
  println(vector)

  // vectors vs lists
  val maxRuns = 1000
  val maxCapacity = 1000000

  def getWriteTime(collection: Seq[Int]): Double = {
    var r = new Random
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }

    times.sum * 1.0 / maxRuns
  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  // Advantage of list is it keeps reference to tails
  // Disadvantage updata an element in the middle takes long
  println(getWriteTime(numbersList))
  // Advantage of vector depth of the tree is small
  // Disadvantage nneds to replace an entire 32-element chunk
  println(getWriteTime(numbersVector))
}
