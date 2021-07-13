package rockthejvm.lectures.part04pm

object PatternsEverywhere extends App {

  // idea #1 -- catches are matches

  try{

  }catch {
    case e: RuntimeException =>
    case ne: NullPointerException =>
    case _ => "something else"
  }

  // catches are matches

  // idea #2 -- generators are also based on pattern matching
  val list = List(1,2,3,4)
  val evenOne = for {
    x <- list if x %2 == 0 // this line is termed as generators
  } yield x*3

  // generators are also based on pattern matching
  // also for tuples, case classes, :: operators, etc

  // idea #3 -- // multiple values matching based on pattern matching

  val tuple = (1,2,3)
  val (a,b,c) = tuple
  println(b)

  val head :: tail = list
  println(head)
  println(tail)

  // idea #4 -- partial function based on pattern matching

  val mappedList = list.map {
    case v if v%2 == 0 => v + " is even"
    case 1 => "One"
    case _ => "something else"
  } // partial function literal

  // above partial function is equivalent to below

  val mappedList1 = list.map { x =>
    x match {
      case v if v % 2 == 0 => v + " is even"
      case 1 => "One"
      case _ => "something else"
    }
  }

  println(mappedList)
  println(mappedList1)

}
