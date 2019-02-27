package Lectures.Part2Oop

object Generics extends App {

  // generic classes
  class MyList[+T] {
    // use the type T
    //def add(element: T): MyList[T] = ???
  }

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  class MyMap[Key, Value]

  // generic methods
  object MyList {
    def empty[T]: MyList[T] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  // Varience
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. yes List[Cat] extends List[Animal] = COVARIANTS
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]

  // does animalList.add(new Dog) work?  THIS A HARD QUESTION

  // 2. NO = INVARIANT LIST
  class InvariantList[A]
  // Thie following doesn't work
  // val invariantAnimalList: InvariantList[Animal] = new InvariantList[Cat]

  // 3. Hell, NO = CONTRAVARIANT
  class ContravariantList[-A]
  val conrtravariantList: ContravariantList[Cat] = new ContravariantList[Animal]

  // bounded types
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)



}
