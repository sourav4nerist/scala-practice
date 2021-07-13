package rockthejvm.lectures.part05adv

import scala.util.Try

object DarkSugars extends App {

  // syntax sugar #1: methods with single params
  def singleArgsMethod(arg: Int) = s"$arg little ducks"

  val description = singleArgsMethod{
    // can have some complex logic to get arg value
    42
  }

  val aTryInstance = Try {
    throw new RuntimeException
  }

  List(1,2,3).map { x =>
    x + 1
  }

  // syntax sugar #2: single abstract method
  trait Action {
    def act(x: Int): Int
  }

  val anInstance: Action = new Action {
    override def act(x: Int): Int = x + 1
  }

  // above can be rewritten as below
  val fancyInstance: Action = (x: Int) => x+1

  // Runnables
  val aThread = new Thread(new Runnable {
    override def run(): Unit = println("scala")
  })

  // above can be rewritten as below
  val newThread = new Thread(() => println("scala"))


  // implementing an unimplemented method in an abstract class
  abstract class AnAbstractClass {
    def implemented: Int = 12
    def f(a: Int): Unit
  }

  val anAbstractInstance: AnAbstractClass = (a: Int) => println(a)

  // syntax sugar #3: the :: and #:: methods are special
  // scala spec: last char of method decides it's associativity,
  // if ends with : then right associative (i.e- executed from right), else left associative

  1 :: 2 :: 3 :: List(4,5)
  // above actually gets calculated as
  List(4,5).::(3).::(2).::(1) //  equivalent

  class MyStream[T] {
    def -->:(value: T): MyStream[T] = this  // actual implementation
  }

  val myStream = 1 -->: 2-->: new MyStream[Int]

  // syntax sugar #4: multi word method naming

  class TeenGirl(name: String) {
    def `and then said`(gossip: String) = println(s"$name  said $gossip")
  }

  val lilly = new TeenGirl("lilly")
  lilly `and then said` "scala"

  // syntax sugar #5: Infix type
  class Composite[A, B]
  val composite: Composite[Int, String] = ???
  // above can be also written as infix way
  val anComposite: Int Composite String = ???

  class -->[A, B]
  val towards: Int --> String = ???

  // syntax Sugar #6: update() is very special like apply()
  val anArray = Array(1,2,3)
  anArray(2) = 7 // rewritten to anArray.update(2,7)
  // used in mutable collection, apply() and update

  // syntax sugar #7: setters for mutable containers
  class Mutable {
    private var internalMember: Int = 0 // private for OO encapsulation
    def member = internalMember
    def member_=(value: Int): Unit =
      internalMember = value // "setter"
  }

  val aMutableContainer = new Mutable
  aMutableContainer.member = 42 // rewritten as aMutableContainer.member_=(42)
}
