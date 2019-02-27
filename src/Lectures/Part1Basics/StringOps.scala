package Lectures.Part1Basics

object StringOps extends App {

  val str: String = "Hello, I am learning Scala"

  println(str.charAt(2))
  println(str.substring(7, 11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase)
  println(str.toUpperCase())
  println(str.length)
  println(str.reverse)  // Scala specific
  println(str.take(2))  // Scala specific

  val aNumberString = "45"
  val aNumber = aNumberString.toInt

  println('a' + aNumberString)

  // Scala specific: String interpolators

  // S-interpolators
  val name: String = "Davie"
  val age: Int = 12
  val greeting = s"Hello, my name is $name and I am $age years old"   // 's' before the string means the string is interpolated
  val anotherGreeting = s"Hello, my name is $name and I will be turning ${age + 1} years old"
  println(greeting)
  println(aNumberString)

  // F-interpolators
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per minute"
  println(myth)

  // raw-interpolator
  println(raw"This is a \n newline")    // the '\n' doesn't get interpreted, it is output as-is (i.e. raw)
}
