package Lectures.Part4PatternMatching

import Lectures.Part3FunctionalProgramming.{Cons, Empty, MyList}

object AllThePatterns extends App {

  // 1 - constants
  val x: Any = "Scala"
  val constants = x match {
    case 1 => "a number"
    case "Scala" => "THE Scala"
    case true => "The Truth"
    case AllThePatterns => "A singleton object"
  }

  // 2 - match anything
  // 2.1 - wildcard

  val matchAnything = x match {
    case _ =>
  }

  // 2.2 - variable (wildcard)
  val matchAVariable = x match {
    case something => s"I've found $something"
  }

  // 3 - tuples
  val aTuple = (1,2)
  val matchATuple = aTuple match {
    case (1,1) =>
    case (something, 2) => s"I've found $something"
  }

  val nestedTuple = (1, (2, 3))
  val matchMNestedTuple = nestedTuple match {
    case (_, (2, v)) =>
  }

  // Pattern Matches can be nested

  // 4 - case classes - this is called a constructor pattern
  // Pattern matching can be nested with case classes as well
  val aList: MyList[Int] = Cons(1, Cons(2, Empty))
  val matchAList = aList match {
    case Empty =>
    case Cons(head, tail) =>
  }

  // 5 - list patterns
  val aStandardList = List(1,2,3,42)
  val standardMatch = aStandardList match {
    case List(1, _, _, _) =>  // extractor - advanced
    case List(1, _*) => // list of arbitrary length - advanced
    case 1::List(_) => // infix pattern
    case List(1,2,3):+42 => // infix pattern
  }

  // 6 - type specifiers
  val unknown: Any = 2
  val unknownMatch = unknown match {
    case list: List[Int] =>  // explicit type specifier
    case _ =>
  }

  // 7 - name binding
  val nameBindingMatch = aList match {
    case nonEmptyList @ Cons(_, _) =>  // name binding => use the name later (here)
    case Cons(1, rest @ Cons(2, _)) => // name binding inside nested patterns
  }

  // 8 - multi patterns
  val multipattern = aList match {
    case Empty | Cons(0, _) => // compound pattern (multi-pattern)
  }

  // 9 - if guards
  val secondElementSpecial = aList match {
    case Cons(_, Cons(specialElement, _)) if specialElement % 2 == 0 =>
  }

  /*
  Question
   */
  val numbers = List(1,2,3)
  val numbersMatch = numbers match {
    case listOfString: List[String] => "a list of strings"
    case listofNumbers: List[Int] => "a list of numbers"
    case _ => ""
  }

  println(numbersMatch)

  // the result is "a list of strings"....JVM trick question!
  // the problem is that the JVM is designed to be backwards compatible.  Unfortunately type generics were introduced
  // in Java 5.  In order to make the JVM compatible the compiler erases the type parameters, thus the above code
  // is effectively equivalent to having written
  //    val numbersMatch = numbers match {
  //    case listOfString: List => "a list of strings"
  //    case listofNumbers: List => "a list of numbers"
  //    case _ => ""
  //  }
  // so the type constraints on the pattern lose their type parameters, patterns are evaluated in order and a List[Int]
  // matches the first pattern....hence the results!
  //
  // This is called type erasure!
}
