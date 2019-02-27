package Lectures.Part2Oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  // anonymous class - compiler effectively creates a new class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("ahahahahah")
  }
  /*
    class AnonymousClasses$$anon$1 extends Animal {
      override def eat: Unit = println("ahahahahah")
    }
    val funnyAnimal: Animal = new AnonymousClasses$$anon$1
   */

  println(funnyAnimal.getClass)


  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is ${this.name}, how can I help?")
  }

  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"Hi, my name is Jim, how can I be of service?")
  }

  jim.sayHi
}
