package Lectures.Part2Oop

object Objects {

  // Scala DOES NOT have class-level functionality (i.e., 'static' in Java)
  // However Scala objects provide similar and more powerful features

  object Person {  // defines a type and it's only instance
    // 'static'/'class' level functionality
    // an 'object' can have val, var and defs
    val N_EYES = 2
    def canFly : Boolean = false

    // this is a factory method as it's purpose is to build Person
    def apply(mother: Person, father: Person): Person = new Person("Bobby")
  }

  class Person(val name: String) {
      // instance level functionality
  }

  // Defining an object and class with the same names is called 'Companions'.


  // Scala Applications - only a scala object with
  // def main(args: Array[String]): Unit

  def main(args: Array[String]) : Unit = {

    println(Person.N_EYES)
    println(Person.canFly)

    // Scala object = SINGLETON INSTANCE
    val mary = new Person("Mary")
    val john = new Person("John")
    println(mary == john)

    val bobby = Person(mary, john)
  }

}
