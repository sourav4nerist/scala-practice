package rockthejvm.lectures.part05adv

object AdvancedPatternMatching extends App {

  val numbers = List(1)
  val description = numbers match {
    case head :: Nil => println(s" the only element is $head")
  }

  /*
  - constants
  - wildcards
  - case classes
  - tuples
   */

  class Person(val name: String, val age: Int)

  object Person{
    def unapply(person: Person): Option[(String, Int)] =
      if(person.age > 15) None
      else Some((person.name, person.age))

    def unapply(age: Int): Option[String] = Some(if(age < 18) "minor" else "manjor")
  }

  val bob =  new Person("Bob", 12)

  val greeting = bob match {
    case Person(a, b) => s"Name: $a, age: $b"
    case _ => "Not found"
  }

  val ageStatus = bob.age match {
    case Person(status) => s"my age is $status"
  }

  println(greeting)
  println(ageStatus)

  /*Exercise*/
  val num = 4
  val mathProperty = num match {
    case x if x<10 =>  "Single digit"
    case x if x%2 ==0 => "Even"
    case _ => "No property"
  }

  // above can be rewritten as

  object even {
    def unapply(arg: Int): Boolean = arg % 2 == 0
  }

  object singleDigit {
    def unapply(arg: Int): Boolean = arg < 10
  }

  val numProperty = num match {
    case singleDigit() => "Even"
    case even() => "Single Digit"
    case _ => "No property"
  }

  println(numProperty)

  // Infix pattern
  case class Or[A, B](a: Int, b: String)
  val either = Or(2,"two")
  val humanDescription = either match {
    case number Or string => s"$number is written as $string"
  }

  println(humanDescription)

  // decomposing sequence
  val varargs = numbers match {
    case List(1, _*) => "starts with 1"
  }

  // for match above type with varargs, we must have our own unapply in list

  abstract class MyList[+A] {
    def head: A = ???
    def tail: MyList[A] = ???
  }

  case object Empty extends MyList[Nothing]
  case class Cons[+A](override val head: A, override val tail: MyList[A]) extends MyList[A]

  object MyList{
    def unapplySeq[A](list: MyList[A]):Option[Seq[A]] =
      if(list == Empty) Some(Seq.empty)
      else unapplySeq(list.tail).map(list.head +: _)
  }

  val myList: MyList[Int] = Cons(1,Cons(2, Cons(3,Empty)))

  val decomposed = myList match {
    case MyList(1,2, _*) => "start with 1,2"
    case _ => "Something else"
  }

  println(decomposed)


  // unapply can have custom return type not necessarily be Option
  // custom type must have isEmpty:Boolean and get:Something methods

  abstract class Wrapper[T]{
    def isEmpty: Boolean
    def get:T
  }

  object PersonWrapper{
    def unapply(arg: Person): Wrapper[String] = new Wrapper[String] {
      override def isEmpty: Boolean = false
      override def get: String = arg.name
    }
  }

  val wrapperOutput = bob match {
    case PersonWrapper(n) => s"name: $n"
    case _ => "Alien"
  }

  println(wrapperOutput)
}
