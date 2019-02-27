package Lectures.Part3FunctionalProgramming

object HOFsAndCurries extends App {

  // function that applies another function, f, n times over a start value x
  // nTimes(f, n, x)
  def nTimes[A](f: A => A, n: Int, x: A) : A = {
    if (n <= 0) x
    else nTimes(f, n - 1, f(x))
  }

  // simple example of adding 3 n times
  def add = (x: Int) => (y: Int) => x + y
  def add3 = add(3)
  println(nTimes(add3, 10, 0))

  // curried function
  def nTimesCurried[A]: (A=>A)=>Int=>A=>A = (f: A => A) => (n: Int) => (x: A) =>
    if (n <= 0) x
    else nTimesCurried(f)(n - 1)(f(x))

  val add3NTimes = nTimesCurried(add3)
  println(add3NTimes(10)(0))
  println(add3NTimes(20)(0))

  // functions with multiple parameter list
  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  // we can use this new syntactic form to give a nicer looking definition of nTimesCurried above
  def nTimesNicerCurriedFormat[A](f: A => A)(n: Int)(x: A): A =
    if (n <= 0) x
    else nTimesNicerCurriedFormat(f)(n-1)(f(x))

  val add5 = add(5)
  val add5Times = nTimesNicerCurriedFormat(add5) _     // this is a partial function application.....in sane!  It seems the nTimesCurried is more elegant, but longer.
  println(add5Times(10)(2))

  /*
    Exercise using Curried HOFs
    1. Expand MyList
      a. foreach method A => Unit
        [1,2,3].foreach(x => println(x))
      b. sort function ((A,A) => Int) => MyList
        [1,2,3].sort((x,y) => y - x) => [3,2,1]
      c. zipWith (MyList[A], (A,A) => B) => MyList[B]
        [1,2,3].zipwith([4,5,6], x * y) => [1*4, 2*5, 3*6]
      d. fold(start)(function) => a value
        [1,2,3].fold(0)(x + y) = 6

     2. toCurry(f: (Int => Int) => Int) => (Int => Int => Int)
        fromCurry(f: Int => Int => Int) => (Int, Int) => Int

     3. compose(f,g) => x => f(g(x))
        andThen(f,g) => x => g(f(x))
   */

  // 1. See MyList file

  // 2.
  def toCurry[A](f:(A,A) => A): (A => A => A) = (x:A) => (y:A) => f(x,y)
  def fromCurry[A](f:A => A => A): (A,A) => A = (x:A, y:A) => f(x)(y)

  def unCurriedAdd = fromCurry(add)
  println(unCurriedAdd(2,3))

  def toCurredAdd = toCurry(unCurriedAdd)
  println(toCurredAdd(5)(10))

  // 3.
  def compose[A,B,C](f:B=>C)(g:A=>B): A => C = x => f(g(x))
  def andThen[A,B,C](f:A=>B)(g:B=>C): A => C = x => g(f(x))

  def subtract(x:Int)(y:Int):Int = x - y
  println(compose(add(3))(add(10))(40))


 }
