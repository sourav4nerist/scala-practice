package rockthejvm.lectures.part03fp

object AnonymousFunctions extends App{

  /*val doubler = new Function[Int, Int] {
    override def apply(x: Int): Int = x * 2
  }*/

  // Above is equivalent to below
  // anonymous function(LAMBDA)
  val doubler = (x: Int) => x * 2
  // equivalent to : val doubler: Int => Int = x => x * 2

  // multi parameters
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  // no param
  val justDoSomething:() => Int = () => 2

  println(justDoSomething) // function instance
  println(justDoSomething()) // function call, lambdas should be called with ()

  // curly braces with lambdas
  val stringToInt = {(s: String) =>
    s.toInt
  }

  // more syntatctic sugar
  val niceIncrement: Int => Int = _ + 1 // is equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ // is equivalent to (a, b) => a + b
}
