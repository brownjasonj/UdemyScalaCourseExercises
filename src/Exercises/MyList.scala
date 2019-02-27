package Exercises


/*
  single linked list with methods

  head - first element of the list
  tail - remainder of the list
  isEmpty - is this list empty
  add(int) => new list with this elem,ent added
  toString => string representation of the list
 */
abstract class MyList {
  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(element: Int) : MyList
  def printElements: String
  override def toString: String = s"[${printElements}]"
}

object Empty extends MyList {
  override def head: Int = throw new NoSuchElementException

  override def tail: MyList = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def add(element: Int): MyList = new Cons(element, Empty)

  def printElements: String = ""
}

class Cons(h: Int, t: MyList) extends MyList {
  override def head: Int = h

  override def tail: MyList = t

  override def isEmpty: Boolean = false

  override def add(element: Int): MyList = new Cons(element, this)

  def printElements: String =
    if (t.isEmpty) "" + h
    else h + "," + t.printElements
}

object ListTest extends App {
  val nList = Empty

  println(nList)
  println(nList.isEmpty)

  val oneElementList = new Cons(1, new Cons(2, Empty))
  println(oneElementList)
  println(oneElementList.isEmpty)

  println(oneElementList.tail.isEmpty)
}
