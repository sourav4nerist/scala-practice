package rockthejvm.exercises.part02basics

object MethodNotations extends App{

  class Person(val name: String, favouriteMovie: String, val age: Int = 0){

    def +(str: String) : Person = new Person(name, str)

    def unary_+ = new Person(name, favouriteMovie, age + 1)

    def learns(str: String) = s"$name learns $str"

    def learnsScala = this learns("scala")

    def apply(num: Int=0): String = s"$name watched $favouriteMovie $num times"
  }

  val mary = new Person("Mary", "Inception")

  println((mary + "the rockstar")())
  println((+mary).age)

  import scala.language.postfixOps
  println(mary learnsScala)

  println(mary(10))

}
