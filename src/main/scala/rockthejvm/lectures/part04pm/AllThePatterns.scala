package rockthejvm.lectures.part04pm

import rockthejvm.exercises.part02basics.{ConsGenerics, EmptyGenerics, MyListGenerics}

object AllThePatterns extends App{
/*

  // 1 - Constants
  val x: Any = "Scala"
  val constants = x match {
    case 1 => "Number"
    case "Scala" => "The Scala"
    case true => "The Truth"
    case AllThePatterns => "Singleton object"
  }

  //2 - match anything
  // 2.1 wildcard
  val matchAny = x match {
    case _ =>
  }

  // 2.2 variable
  val matchVariable = x match {
    case something => s"I have found $something"
  }

  // 3 Tuples
  val aTuple = (1,2)
  val matchATuple = aTuple match{
    case(1,1) =>
    case(something, 1) => s"I have $something"
  }

  val nestedTuple = (1, (2,3))
  val matchNestedTuple = nestedTuple match {
    case(_,(1, v)) =>
  }

  // PMS can be nested

  // 4 case classes -- constructor pattern
  // PM can be nested with case classes as well

  val aList: MyListGenerics[Int] = ConsGenerics(1, ConsGenerics(2, EmptyGenerics))
  val matchAList = aList match {
    case EmptyGenerics =>
    case ConsGenerics(head, tail) =>
    case ConsGenerics(head, ConsGenerics(subhead, tail)) =>
  }


  // 5 - List patterns
  val aStandardList = List(1,2,3,4)
  val standardMatching = aStandardList match {
    case List(1, _, _ ,_ ) => // extractor - advanced
    case List(1 , _ *) => // list of arbitrary length - advanced
    case 1 :: List(_) => // Infix pattern
    case List(1,2,3) :+ 42 => //infix pattern
  }

  // 6 - Type specifiers
  val unknown: Any = 2
  val unknownMatch = unknown match {
    case list: List[Int] => // explicit type specifier
    case _ =>
  }

  // 7- name binding
  val nameBindingMatch = aList match {
    case nonEmptyList @ ConsGenerics(_, _) => // name binding => use the name later
    case ConsGenerics(1, rest @ ConsGenerics(_,_)) => // name binding inside nested patterns
  }

  // 8 - multi patterns
  val multiPattern = aList match {
    case EmptyGenerics | ConsGenerics(0, 1) => // compound pattern or multi pattern
  }

  // 9 - if guard
  val secondElementSpecial = aList match {
    case ConsGenerics(_, ConsGenerics(specialElement, _)) if specialElement % 2 == 0 =>
  }
*/

  val listOfNum = List(1,2,3,4)
  val numbersMatch = listOfNum match {
    case listOfString: List[String] => "String"
    case listOfInt: List[Int] => "Int"
    case _ => ""
  }

  println(numbersMatch) // prints "String",
  // this is called eraser issue of jvm
  // it's because java removes generics post type check
  // to make jvm compatible with older java which makes
  // our program look like :
  /*
  val numbersMatch = listOfNum match {
    case listOfString: List=> "String"
    case listOfInt: List => "Int"
    case _ => ""
  }
   */

}
