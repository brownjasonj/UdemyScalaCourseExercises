package Lectures.Part3FunctionalProgramming

object AnonymousFunctions extends App {

  // The previous way to define a function is via the object trait
  val doubler = new Function1[Int, Int] {
    override def apply(v1: Int): Int = v1 * 2
  }

  // Scala provides a syntactic sugaring that makes defining functions easier
  // the above can be more simply defined as follows
  // this is called an anonymous function or (lambda function)
  val doublerB = (x: Int) => x * 2

  // we can declare the type of the function as follows
  val doublerC: Int => Int = x => x * 2

  // multiple parameters
  val add: (Int, Int) => Int = (x: Int, y: Int) => x + y

  // no parameters
  val justDoSomething: () => Int = () => 3

  // be careful
  println(justDoSomething)  // this is the function itself
  println(justDoSomething()) // this is the application of the function

  // curly braces with lambda
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // More syntactic sugaring
  val niceIncrementer: Int => Int = _ + 1  // equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ // equivalent to (x, y) => x + y

  /*
    Exercises:
    1. go to MyList and replace all FunctionX calls with lambdas
    2. Rewrite the "special" adder as an anonymous function
   */

  // 1. See MyList file

  // 2.
  val specialAdder = (x: Int) => (y: Int) => x + y

  val add3 = specialAdder(3)

  println(add3(10))
  println(specialAdder(25)(10))
}
