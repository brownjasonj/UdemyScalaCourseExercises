package Lectures.Part1Basics

import Lectures.Part1Basics.CBNvCBV.calledByValue

object DefaultArgs extends App {

  def tailrecursiveFactorial(n: Int, acc: Int) : Int =
    if (n <= 1) acc
    else tailrecursiveFactorial(n-1, n*acc)

  val fact10 = tailrecursiveFactorial(10, 1)

  // using the tailrecursive factorial requires one to set the start accumulator which always needs to be 1
  // so one can use scala argument default value to remove the necessity of always setting it to 1

  def tailrecursiveFactorialDefalut(n: Int, acc: Int = 1) : Int =
    if (n <= 1) acc
    else tailrecursiveFactorialDefalut(n-1, n * acc)

  // now it can be called with the second argument
  val anotherFact10 = tailrecursiveFactorialDefalut(10)

  // using default parameters introduces problems with how a call to the function is intepreted
  // for example

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int =  1080): Unit = println("saving picture as " + format + "(" + width + ", " + height +")")

  // but calling savePicture(800,600) causes a compile error since the compiler sees the first argument '800' type
  // mismatching 'String' the first argument of the function definition
  // to overcome this one can name the arguments in the call

  savePicture(width = 800, height = 600)

  // this helps the compiler correctly assign the calling argument with the

  savePicture(height = 912, width = 1024, format = "bitmap")
}
