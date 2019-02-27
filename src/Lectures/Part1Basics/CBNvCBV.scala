package Lectures.Part1Basics

object CBNvCBV extends App {

  def calledByValue(x: Long) : Unit = {
    println("by value " + x)
    println("by value " + x)
  }

  // the syntax '=>' before the type Long defines the argument as a call by reference, instead of by value.
  def calledByReference(x: => Long) : Unit = {
    println("by value " + x)
    println("by value " + x)
  }

  calledByValue(System.nanoTime())
  calledByReference(System.nanoTime())

  def infinite(): Int = 1 * infinite()

  def printFirst(x: Int, y: => Int): Unit = println(x)

  //printFirst(infinite(), 34)    // this will fail as the call evaluates infinite() which has an infinite loop and this fails
  printFirst(34, infinite)  // this is fine since the second parameter to the call is 'by reference' and since the function doesn't use the value the arguement is not evaluated
}
