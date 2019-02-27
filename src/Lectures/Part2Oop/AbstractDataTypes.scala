package Lectures.Part2Oop

object AbstractDataTypes extends App {

  // abstract - don't supply values or definitions for some members
  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }

  // you can't create instances of abstract class, so the following with cause a compile error
  // val animal = new Animal

  class Dog extends Animal {
    override val creatureType: String = "Canine"

    override def eat: Unit = println("crunch crunch")
  }

  // traits - like interfaces in Java
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "Croc"

    override def eat: Unit = println("nomnomnom")

    override def eat(animal: Animal): Unit = println(s"I'm a croc and i'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val crocodile = new Crocodile

  crocodile.eat(dog)


  // Abstract class verses Trait
  // 1 - traits don't have constructor parametera
  // 2 - multiple traits can be inherited by a class
  // 3 - traits = behaviour.  Abstract class is a type of things


}
