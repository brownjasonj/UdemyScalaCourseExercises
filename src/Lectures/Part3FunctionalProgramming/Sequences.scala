package Lectures.Part3FunctionalProgramming

object Sequences extends App {

  // Sequences
  val aSequence = Seq(1, 2, 3, 4)

  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(5,6,7))
}
