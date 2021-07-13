package rockthejvm.lectures.part03fp

object WhatsAFunction extends App {

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))

  // function types in scala : Function1 to Function22

  val stringToIntConverter = new Function1[String, Int]{
    override def apply(str: String): Int = str.toInt
  }

  println(stringToIntConverter("2"))

  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }

  // Function types Function2[A, B, R] === (A,B) => R

  // ALL SCALA FUNCTIONS ARE OBJECTS

  def concatenator:(String, String) => String = new Function2[String, String, String] {
    override def apply(a: String, b: String) = a + b
  }

  println(concatenator("Hello ", "Scala"))

  val superAdder : Function1[Int,  Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  val adder3 = superAdder(3)
  println(adder3(4))
  println(superAdder(3)(4)) // curried function

  // superadder as ananymous function

  val superAdd = (x :Int) => (y : Int) => x + y
  println(superAdd(2)(3))
  println(superAdd(2)) // prints instance of superAdd
}

trait MyFunction[A, B]{
  def apply(element: A): B = ???
}
