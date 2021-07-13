package rockthejvm.lectures.part02oops

object MethodNotations extends App{

  class Person(val name: String, favouriteMovie: String){
    def likes(movie: String): Boolean = movie == favouriteMovie
    def hangoutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    // this is also possible in scala
    // def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def unary_! : String = s"this is not $name"

    def isAlive: Boolean = true

    def apply(): String = s"Hi, My name is $name and I like $favouriteMovie"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception")  // Infix notation(syntactic sugar), only works with method with single parameter

  // Operators in scala
  val tom = new Person("Tom", "Fight Club")
  println(mary hangoutWith tom)
  //println(mary + tom)
  println(1 + 2) // is equivalent to below as + operator is a method
  println(1.+(2))

  // ALL OPERATORS ARE METHODS.

  // Prefix notations

  val x = -1 // equivalent to below
  val y = 1.unary_-
  // unary_ prefix only works with + - ~ !

  println(!mary) // equivalent to below
  println(mary.unary_!)

  // Postfix notation
  import scala.language.postfixOps // needs to be imported to use postfix operator
  println(mary isAlive)

  // apply
  println(mary.apply()) // is equivalent to below
  println(mary())       // when an instance is called with (), internally compiler calls for apply method

}
