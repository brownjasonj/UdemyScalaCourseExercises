package Lectures.Part1Basics

object Functions extends App {

  def aFunction(a: String, b: Int) = {
    a + " " + b
  }

  println(aFunction("Hello", 3))

  def aParameterlessFunction() : Int = 42

  println(aParameterlessFunction())
  println(aParameterlessFunction)     // calling a function without parameter brackets STILL calls the function.  it DOESNOT return the function as a value!!!

  def aRepeatedFunction(aString: String, n:Int): String  = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }

  println(aRepeatedFunction("Hello", 3))

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    // you can define functions within code blocks
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n-1)
  }


  /*
    1. A greeting function (name, aga) => "Hi, my name is {name} and I am $age years old'
    2. factorial fucntion 1 * 2 * 3 * 4 * ... * n
    3. a fibonacci function
      f(1) = 1
      f(2) = 1
      f(n) = f(n - 1) + f(n-2)
    4. test if a number is prime
   */

  def aGreetingFunction(name: String, age: Int): Unit = {
    println("Hi, my name is " + name + " and I am " + age + " years old")
  }

  aGreetingFunction("fred", 12)

  def factorial(n: Int) : Int =
    if (n <= 0) 1
    else n * factorial(n - 1)

  println(factorial(10))

  def fibonacci(n: Int) : Int =
    if (n <= 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)


  println(fibonacci(10))
  println(fibonacci(20))

  def isPrime(n: Int) : Boolean = {
    def isPrimeUntil(t: Int) : Boolean =
      if (t <= 1) true
      else (n % t != 0) && isPrimeUntil(t - 1)

    isPrimeUntil(n / 2)
  }

  println(isPrime(37))
  println(isPrime(2003))
  println(isPrime(37 * 17))


}
