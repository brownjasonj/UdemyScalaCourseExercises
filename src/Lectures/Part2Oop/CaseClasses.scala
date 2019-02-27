package Lectures.Part2Oop

object CaseClasses extends App {

  case class Person(name: String, age: Int)

  /*
    The 'case' keyword applied to a class gives you a bunch of features on the class

    1. class parameters are fields
   */
  val jim = new Person("Jim", 34)
  println(jim.name)

  // 2. sensible toString
  // println(instance) = println(instance.toString)
  println(jim)

  // 3. equals and hashCode are implemented OOTB
  // equals is now semantic equivalence instead of object instance equivalance.  without the case word infront of
  // class the following would return false, but now it returns true
  val jim2 = new Person("Jim", 34)
  println(jim == jim2)


  // 4. handy copy methods
  val jim3 = jim.copy()
  // also with constructor parameters
  val jim4 = jim.copy(age = 45)

  // 5. companion objects
  val thePerson = Person

  // apply is defined on the companion object Person that constructs an instance of Person
  val mary = Person("Mary", 23)

  // 6. CCs are serialable
  // highly used in Akka

  // 7. CCs have extractor patterns = CC can be used in PATTERN MATCHING

  // case object, like a case class, but is an object.  Behaves like case class, but without companion object since
  // is itself an object
  case object UnitedKingdom {
    def name: String = "The UK of Great Britain and Northern Ireland"
  }
}
