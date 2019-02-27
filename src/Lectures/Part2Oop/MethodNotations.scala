package Lectures.Part2Oop

object MethodNotations extends App {

  class Person(val name: String, favouriteMovie: String) {
    def likes(movie: String) : Boolean = movie == favouriteMovie
    def hangsOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    // example of prefix unary operator
    def unary_! : String = s"$name what the heck?!"

    // example of postfix operator. NB the method have NO parameters
    def isAlive: Boolean = true

    // example of special 'apply' method
    // NB: you need the () parentheses
    def apply(): String = s"Hi my name is $name and I live $favouriteMovie"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception")   // infix/operator notion.  Only works with methods with a single parameter.  An example of syntactic sugar

  val tom = new Person("Tom", "Fight Club")
  println(mary hangsOutWith tom)

  println(1 + 2)
  println(1.+(2))

  // ALL operators are methods
  // ONLY methods with single parameters are operators
  // Akka actors have ! and ? name methods/operators

  // PREFIX notation - another form of syntactic sugar

  val x = -1;
  val y = 1.unary_-     // this is equivalent

  // unary_ prefix only with with -, +, ~, ! operators
  println(!mary)
  println(mary.unary_!)

  // POSTFIX
  println(mary.isAlive)
  println(mary isAlive)

  // APPLY is a special method name
  println(mary.apply())
  println(mary())   // equivalent to mary.apply().  only works because apply is a special case method name in scala

  /*
    Exercise

    1. Overload the + operator
        mary + "the rockstar"  => new person "Mary (the rockstar)"
    2. Add an age to the Person class
        Add a unary + operator => new Person with the age + 1
       +mary => mary with the age incremented
    3. Add a "learns" method in the Person class => "Mary learns Scala"
       Add a learnsScala method, calls learns method with "Scala"
       Use it in postfix notation
    4. Overload the apply method
       mary.apply(2) => "Mary watched Inception 2 times
   */

  class NewPerson(val name: String, val age: Int, favouriteMovie: String) {
    def likes(movie: String) : Boolean = movie == favouriteMovie

    def +(nickName: String) : NewPerson = new NewPerson(s"${this.name} ($nickName)", this.age, this.favouriteMovie)

    def unary_+ : NewPerson = new NewPerson(this.name, this.age + 1, this.favouriteMovie)

    def learns(subject: String): String = s"${this.name} learns $subject"

    def learnsScala: String = this.learns("Scala")

    def apply(timesWatchMovie: Int): String = s"${this.name} watch ${this.favouriteMovie} $timesWatchMovie times"

    def print: String = s"${this.name} is ${this.age} years old whose favorite movie is ${this.favouriteMovie}"
  }

  val yvette = new NewPerson("Yvette", 12, "Mary Poppins")
  println(yvette.print)

  val yvetteRockStar = yvette + "the rockstar"
  println(yvetteRockStar.print)

  val yvetteBirthDay = +yvette
  println(yvetteBirthDay.print)

  println(yvette learns "Java")
  println(yvetteBirthDay learnsScala)

  println(yvette(5))
}
