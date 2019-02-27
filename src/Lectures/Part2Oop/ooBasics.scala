package Lectures.Part2Oop

// NB: class parameters are NOT FIELDS
// use 'val' to the class parameters
class Person(name: String, val age: Int) { // constructor
  // class body
  val x = 2   // this is a field

  println( 1 * 3)   // this is evaluated on instantiation

  // multiple constructors
  def this(name: String) = this(name, 0)

  // how to reference class related variables, even if not a  field
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")
  // overloading
  def greet(): Unit = println(s"Hi, I am $name")
}

/* Exercise

  Novel and a Writer

  Writer: first name, surname, year
    - method fullname

  Novel: name, year of release, author (a Writer)
    - authorAge - age of author at year of release
    - isWrittenBy(author)
    - copy(new year of release) = new instance of Novel

 */
class Writer(firstName: String, lastName: String, val birthYear: Int) {
  def fullName(): String = s"$firstName $lastName"
}

class Novel(title: String, pubYear: Int, author: Writer) {
  def authorAge() : Int = pubYear - author.birthYear
  def isWrittenBy(name: String): Boolean = author.fullName().equals(name)
  def copy(newYear: Int): Novel = new Novel(title, newYear, author)
}


/* Exercise

  Counter class
    - receives an int value
    - method current count
    - method to increment/decrement => new Counter
    - overload inc/dec to receive an amount
 */
class Counter(val count: Int = 0) {
  def increment = {
    println("incrementing")
    new Counter(count  + 1)
  }
  def increment(n: Int) : Counter = {
    if (n <= 0) this
    else increment.increment(n - 1)
  }
  def decrement = {
    println("decrementing")
    new Counter(count - 1)
  }
  def decrement(n: Int) : Counter = {
    if (n <= 0) this
    else decrement.decrement(n - 1)
  }

  def print = println(count)
}

object ooBasics extends App {
  var person: Person = new Person("John", 26)

  println(person.age)
  println(person.x)

  person.greet("Daniel")
  person.greet()

  val jamesBaldwin: Writer = new Writer("James", "Baldwin", 1935)
  val giovannisRoomFirstEdition = new Novel("Giovanni's Room",1960, jamesBaldwin)
  val giovannisRoomSecondEdition = giovannisRoomFirstEdition.copy(1970)

  println(jamesBaldwin.fullName())
  println(giovannisRoomFirstEdition.authorAge());
  println(giovannisRoomSecondEdition.authorAge())
  println(giovannisRoomSecondEdition.isWrittenBy("James Baldwin"))

  val aCounter = new Counter()
  aCounter.increment.print
  aCounter.increment(10).print


}

