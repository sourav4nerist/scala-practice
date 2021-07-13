package rockthejvm.lectures.part03fp

object HOFsCurries extends App {

  //val dic= (a:Int) => a * 2

  // function that applies a function(f) n times over x
  def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if (n <= 0) x
    else nTimes(f, n - 1, f(x))

  val plusOne = (x: Int) => x + 1
  println(nTimes(plusOne, 10, 1))

  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) =
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n - 1)(f(x))

  val plusTen = nTimesBetter(plusOne, 10)

  println(plusTen(1))

  // curried functions
  val superAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
  val add3 = superAdder(3)
  println(add3(10))
  println(superAdder(3)(10))

  //function with multiple parameter lists
  def curriedFormatter(c: String)(f: Double): String = c.format(f)

  val standardFormatter:(Double => String) = curriedFormatter("%4.2f")
  val preciseFormatter:(Double => String) = curriedFormatter("%10.8f")

  println(standardFormatter(Math.PI))
  println(preciseFormatter(Math.PI))


  def toCurry(f:(Int,Int) => Int): Int => Int => Int = x => y => f(x,y)
  def fromCurry(f: Int => Int => Int): (Int, Int) => Int = (x, y) => f(x)(y)
  // Functionx
  def compose[A,B,T](f: A => B, g: T => A): T => B = x => f(g(x))
  def andThen[A,B,T](f: A => B, g: B => T): A => T = x => g(f(x))

  def superAdder2: Int => Int => Int = toCurry(_+_)
  def add4 = superAdder2(4)

  val simpleAdder = fromCurry(superAdder2)

  val add5 = (x:Int) => x +5
  val times5 = (x:Int) => x * 5

  println("add4:" + add4(17))
  println(simpleAdder(17,4))
  println(compose(add5,times5)(4))
  println(andThen(add5, times5)(4))


}