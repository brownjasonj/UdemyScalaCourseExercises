package Lectures.Part3FunctionalProgramming


object WhtasAFunction extends App {
  // Dream: use functions as first class elements
  // problem: coming from object oriented programming.  "functions" are just members of classes/objects

  // We use apply with traits to 'simulate' functions in an object oriented way by using the apply to give us
  // an easy way to call the function directly without having to access the member function
  // example:  single argument function
  trait MyFunction[A, B] {
    def apply(element: A) : B
  }

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))

  // The MyFunction trait is available natively in Scala named as Function1, upto Function22 depending on number
  // of arguments
  // example:
  val stringToInt = new Function1[String, Int] {
    override def apply(v1: String): Int = v1.toInt
  }

  println(stringToInt("33"))

  // example of a two parameter function
  val adder = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }
  // the above has type Function2[Int, Int, Int]
  // but scala has syntactic sugaring to let us write this as ((Int, Int) => Int)

  // more generally
  // Function2[A, B, C] === (A, B) => C

  // ALL SCALA FUNCTIONS ARE OBJECTS!!!

  /*
    Exercises:
    1. a function which takes 2 strings and cnoncatenates them
    2. transform the MyPredicate and MyTransformer into function types
    3. define a function which takes an int and returns another function which takes an int and returns an int
      - what's the type of this function
      - how to do it
   */

  // 1.
  val stringConcat = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  // 2. See new version of MyList in this package

  // 3.
  val addN = new Function1[Int, Function1[Int,Int]] {
    override def apply(v1: Int): Int => Int = new Function1[Int, Int] {
      override def apply(v2: Int): Int = v1 + v2
    }
  }

  val add3 = addN(3)

  println(add3(10))
  println(add3(33))
}

