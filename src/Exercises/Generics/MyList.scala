package Exercises.Generics


/*  Exercise
  1. Generic trait MyPredicate[A] - method to check if the object of type A passes some condition
  2. Generic trait MyTransformer[A, B] - method to convert an object of type A to an object of type B
  3. Implement the following on MyList[A]
    - map(transformer) => MyList
    - filter(predicate) => MyList
    - flatMap(transformer from A to MyList[B]) => MyList[B]


 */

trait MyPredicate[T] {
  def pass(element: T) : Boolean
}

trait MyTransformer[S,T] {
  def transform(s:S): T
}

abstract class MyList[+T] {
  def head: T
  def tail: MyList[T]
  def isEmpty: Boolean
  def add[S >: T](element: S) : MyList[S]
  def ++[S >: T](l: MyList[S]): MyList[S]

  def map[S >: T, P](trans: MyTransformer[S,P]): MyList[P]
  def filter[S >: T](pred: MyPredicate[S]): MyList[S]
  def flatMap[S>:T, P](trans: MyTransformer[S,MyList[P]]): MyList[P]

  def printElements: String
  override def toString: String = s"[${printElements}]"
}

case object Empty extends MyList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException
  override def tail: MyList[Nothing]  = throw new NoSuchElementException
  override def isEmpty: Boolean = true
  override def add[S >: Nothing](element: S): MyList[S] = new Cons(element, Empty)
  override def ++[S >: Nothing](l: MyList[S]): MyList[S] = l

  override def map[S >: Nothing, P](trans: MyTransformer[S, P]): MyList[P] = Empty
  override def filter[S >: Nothing](pred: MyPredicate[S]): MyList[S] = Empty
  override def flatMap[S >: Nothing, P](trans: MyTransformer[S, MyList[P]]): MyList[P] = Empty

  def printElements: String = ""
}

case class Cons[+T](h: T, t: MyList[T]) extends MyList[T] {
  override def head: T = h
  override def tail: MyList[T] = t
  override def isEmpty: Boolean = false
  override def add[S >: T](element: S): MyList[S] = new Cons(element, this)
  override def ++[S >: T](l: MyList[S]): MyList[S] = new Cons(h, t ++ l)

  override def map[S >: T, P](trans: MyTransformer[S, P]): MyList[P] = new Cons(trans.transform(h), t.map(trans))
  override def filter[S >: T](pred: MyPredicate[S]): MyList[S] =
    if (pred.pass(h)) new Cons(h, t.filter(pred))
    else t.filter(pred)
  override def flatMap[S >: T, P](trans: MyTransformer[S, MyList[P]]): MyList[P] = trans.transform(h) ++ t.flatMap(trans)

  def printElements: String =
    if (t.isEmpty) "" + h
    else h + "," + t.printElements
}




object ListTest extends App {
  val listofIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val listofString: MyList[String] = new Cons("John", new Cons("Fred", new Cons("Mary", Empty)))

  println(listofIntegers.toString)
  println(listofString.toString)

  println(listofIntegers.map(new MyTransformer[Int,Int] {
    override def transform(s: Int): Int = s * 2
  }).toString)

  println(listofIntegers.flatMap(new MyTransformer[Int,MyList[Int]] {
    override def transform(s: Int): MyList[Int] = new Cons(s, new Cons(s, Empty))
  }).toString)

  println(listofIntegers.flatMap(new MyTransformer[Int,MyList[Int]] {
    override def transform(s: Int): MyList[Int] = new Cons(s, new Cons(s, Empty))
  }).filter(new MyPredicate[Int] {
    override def pass(element: Int): Boolean = (element % 2) == 1
  }).toString)

  // because we now use 'case' for Empty and Cons we get the equals for free......
  val cloneListOfIntegers = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(listofIntegers == cloneListOfIntegers)

}