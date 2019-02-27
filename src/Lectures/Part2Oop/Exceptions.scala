package Lectures.Part2Oop

object Exceptions extends App {

  val x: String = null
  // println(x.length)
  // this throws a NullPointer exception

  // throwing and catching exception

  // 1. throwing exceptions
  //val aWeirdValue = throw new NullPointerException

  // throwable classes extend the Throwable class
  // Exception and Error are the major Throwable subtypes
  // Exception - something went wrong with the program
  // Error - something went wrong with the system

  // 2. Catching exceptions
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No Int for you")
    else 42

  val potentialFail = try {
    getInt(false)
  } catch {
    case e: RuntimeException => println("caught a RuntimeException")
  } finally {
    // code that will get executed NO MATTER WHAT
    // finally is optional
    // it doesn't influence the return type of the try-catch expression
    // use finally ONLY for side effects (e.g., writing logs etc.)
    println("finally")
  }

  // 3. defining your own exceptions
  class MyException extends Exception
  val exception = new MyException

  // throw exception


  /*
    Exercises:
    1. Crash your program with an OutOfMemoryError
    2. Crash with StackOverFlowError
    3. PocketCalculator
      - add(x,y)
      - subtract(x,y)
      - multiply(x,y)
      - divide(x,y)

      Throw
        - OverflowException if add(x,y) exceeds Int.MAX_VALUE
        - UnderflowException if subtract(x,y) exceeds Int.MIN_VALUE
        - MathCalculationException for divide by 0
   */

  // 1. OutOfMemoryError - OOM
  // val array = Array.ofDim(Int.MaxValue)

  // 2. StackOverFlowError - SO
  // def infinite: Int = 1 + infinite
  // val noLimit = infinite

  // 3. PocketCalculator

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by 0")

  object PocketCalculator {
    def add(x: Int, y: Int): Int = {
      val result = x + y
      if(x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x: Int, y: Int): Int = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y: Int): Int = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def divide(x: Int, y: Int): Int = {
      if (y == 0) throw new MathCalculationException
      else x / y
    }
  }

  // println(PocketCalculator.add(Int.MaxValue, 10))
  println(PocketCalculator.divide(Int.MaxValue, 0))
}
