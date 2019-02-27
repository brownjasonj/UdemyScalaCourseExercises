package Lectures.Part3FunctionalProgramming

object MapFilterFilterFor extends App {

  val list = List(1,2,3)
  println(list)
  println(list.head)
  println(list.tail)

  // map
  println(list.map(_ + 1))
  println(list.map(_ + " is a numnber"))

  // filter
  println(list.filter(_ % 2 == 0))

  // flatmap
  val toPair = (x: Int) => List(x, x+1)
  println(list.flatMap(toPair))

  // exercise:  print out all combinations between two lists
  val numbers = List(1,2,3,4)
  val chars = List('a','b','c','d')
  val colours = List("red", "black", "white")

  val combinations1 = numbers.flatMap((x:Int) => chars.map("" + _ + x))
  val combinations2 = chars.flatMap((x:Char) => numbers.map("" + x + _))
  println(combinations1)
  println(combinations2)

  val combinations3 = numbers.flatMap(n => chars.flatMap(c => colours.map(colour => "" + c + n + colour)))
  println(combinations3)

  // The above is quite hard to read for people
  // Scala provides an alternative called for-comprehensions
  val combinations4 = for {
    n <- numbers
    c <- chars
    colour <- colours
  } yield "" + c + n + colour
  println(combinations4)

  // we can add filers to for-comprehensions too, for example the folllowing
  val combinations5 = numbers.filter(_ % 2 == 0).flatMap(n => chars.flatMap(c => colours.map(colour => "" + c + n + colour)))
  println(combinations5)

  // can be written as the following for-comprehensions
  val combinations6 = for {
    n <- numbers if n % 2 == 0
    c <- chars
    colour <- colours
  } yield "" + c + n + colour
  println(combinations6)

  for {
    n <- numbers
  } println(n)

  // syntax
  println(list.map(x => x * 2))

  /*
  1. MyList supports for-comprehensions
  2. A small collection of at most ONE element - MayBe[+T]
      - map, flatmap, filter
   */
}
