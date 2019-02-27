package Lectures.Part2Oop

object Inheritance extends App {

  // Scala offers single class inheritance
  class Animal {
    val creatureType = "Wild"

    def eat: Unit = println("nonmnom")
  }

  class Cat extends Animal {
    def crunch = {
      this.eat
      println("crunch crunch")
    }
  }


  val cat = new Cat

  cat.crunch
  println(cat.creatureType)

  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name)


  // overloading
  class Dog extends Animal {
    override val creatureType: String = "Domestic"

    override def eat = println("crunch, crunch")
  }

  val dog = new Dog
  dog.eat

  println(dog.creatureType)

  // it is possible to override vals in the parameter of the constructor
  class Horse(override val creatureType: String) extends Animal {

  }

  val horse = new Horse("Not so Wild")
  println(horse.creatureType)


  // type substitution  (called polymophism
  val unknownAnimal: Animal = new Dog

  // this prints 'crunch crunch' because the eat method call with be that of
  // the most specific implementation, in this case it is a Dog!
  unknownAnimal.eat


  // super - to access

  class Pig extends Animal {
    override def eat = {
      super.eat // calls eat from the Animal class
      println("Woff woff")
    }
  }

  val pig = new Pig
  pig.eat

  // preventing overrides
  // 1 - use final on member  - can't override the member
  // 2 - use final on the class  - can't override the class (i.e., can't extend'
  // 3 - seal the class  - can extend classes in this file, but prevents extension in other files!
}
