package Lectures.Part2Oop

import Exercises.Generics.{Cons, Empty, MyList}

// an alternative to the above, you can import everyting using _
// import Exercises.Generics._

object PackagingAndImports extends App {

  // package members are accessible by their simple name (Writer is in the ooBasics file in the same Lectures.Part2Oop package so is accessible here)
  val writer = new Writer("Daniel", "RockTheJVM", 2018)

  println(writer)

  // Otherwise, the package needs to be imported.
  val listofIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val listofString: MyList[String] = new Cons("John", new Cons("Fred", new Cons("Mary", Empty)))

  // packages are in hierarchy
  // matching folder structure

  // package object  -  seee file 'package'
  sayHello
  println(SPEED_OF_LIGHT)


}
