package rockthejvm.lectures.part05advfp

object PartialFunction extends App{

  val aFunction = (x: Int) => x + 1 // Function1[Int,Int] === Int => Int

  val aFussyFunction = (x: Int) =>
    if(x == 1) 1
    else if (x == 2) 2
    else if (x == 3) 3
    else throw new FunctionNotApplicableException

  class FunctionNotApplicableException extends RuntimeException

  val aNicerFussyFunction = (x: Int) => x match {
    case 1 => 1
    case 2 => 2
    case 3 => 3
  }   // {1,2,3} => Int

  // the above function can be re written as partial function as input is subset of a specific type

  val aPartialFunction: PartialFunction[Int, Int] = {
    case 1 => 1
    case 2 => 2
    case 3 => 3
  }  // partial function

  println(aPartialFunction(2))
  //println(aPartialFunction(54))

  // Partial function utilities
  // isDefinedAt  - check if value is applicable to pf
  println(aPartialFunction.isDefinedAt(54))

  // lift - converts a partialFunction to full function by returning Option
  val lifted = aPartialFunction.lift  // Int => Option[Int]
  println(lifted(2))
  println(lifted(54))

  val pfChain = aPartialFunction.orElse[Int, Int] {
    case 45 => 45
  }

  println(pfChain(45))

  // PF extends normal function i.e pf is child to normal function

  val aTotalFunction: Int => Int = {
    case 1 => 1
  }

  // HOFs accept pf as well
  val aMappedFunction = List(1,2,3).map {
    case 1 => 1
    case 2 => 2
    case 3 => 1000
  }
  println(aMappedFunction)

  /*
  Partial FUnction can have only one date type
   */

  /*
  Exercise :
  1. construct a pf instance using anonymous class
  2. dumb chatbot
   */

  val aManualPf = new PartialFunction[Int, Int] {
    override def apply(v1: Int): Int = v1 match {
      case 1 => 1
      case 2 => 2
      case 5 => 5
    }

    override def isDefinedAt(x: Int): Boolean =
      x == 1 || x== 2 || x == 5
  }

  val chatbot: PartialFunction[String, String]= {
    case "hello" => "Hello, How are you?"
    case "quit" => "You want to exit?"
    case _ => "Couldn't understand"
  }

  scala.io.Source.stdin.getLines().map(chatbot).foreach(println)



}
