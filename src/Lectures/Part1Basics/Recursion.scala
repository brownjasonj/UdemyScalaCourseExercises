package Lectures.Part1Basics

import Lectures.Part1Basics.Functions.isPrime

import scala.annotation.tailrec

object Recursion extends App {
  def factorial(n: Int) : BigInt =
    if (n <= 0) 1
    else n * factorial(n - 1)

  //println(factorial(20000))

  def anotherFactorial(n: Int) : BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt) : BigInt =
      if (x < 1) accumulator
      else factHelper(x - 1, x * accumulator)

    factHelper(n, 1)
  }

  // println(anotherFactorial(20000))

  /*
  create tail recursive functions for the following
  1. Concatenate a string n times
  2. isPrime
  3. fibonacci
   */

  def aRepeatedFunction(aString: String, n:Int): String  = {
    @tailrec
    def repeatStringHelper(s: String, remainder: Int, accumulator: String): String = {
      if (remainder <= 0) accumulator
      else repeatStringHelper(s, remainder - 1, s + accumulator)
    }

    repeatStringHelper(aString, n, "")
  }

  println(aRepeatedFunction("Hello", 3))

  def isPrime(n: Int) : Boolean = {
    @tailrec
    def isPrimeUntil(t: Int, acc: Boolean) : Boolean =
      if (t <= 1) acc
      else isPrimeUntil(t - 1, acc && (n % t != 0))

    isPrimeUntil(n / 2, true)
  }


  println(isPrime(37))
  println(isPrime(2003))
  println(isPrime(37 * 17))


  def fibonacci(n: Int) : Int = {
    @tailrec
    def fibHelper(i: Int, p1: Int, p2: Int): Int = {
      if (i >= n) p1
      else fibHelper(i + 1, p1 + p2, p1);
    }

    if (n <= 2) 1
    else fibHelper(2, 1, 1)
  }

  println(fibonacci(10))
  println(fibonacci(20))
}
