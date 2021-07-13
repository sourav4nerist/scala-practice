package rockthejvm.lectures.part04pm

import scala.util.Random

object PatternMatching extends App {

  // switch
  val random = new Random()
  val x = random.nextInt(10)

  val description = x match {
    case 1 => "ONE"
    case 2 => "TWO"
    case 3 => "THREE"
    case _ => "Default"
  }

  println(description)

  // Decompose value

  case class Person(name: String, age:Int)
  val bob = Person("Bob", 11)

  val greeting = bob match {
    case Person(a,n) if n < 21 => s"Name: $a, age is less than 21"
    case Person(a,n) => s"Name: $a, age: $n"
    case _ => "Not a person"
  }

  println(greeting)

  /*
  1. cases are matched in order
  2. If no case match? MatchError
  3. type of PM expression? unified type of all the types in the cases
  4. PM works really well with case class in place of normal classes because of inbuilt extractors
   */

  // PM on sealed hierarchies - must be exhaustive i.e. all type should be covered in case or else compilation error

  sealed class Animal
  case class Dog(breed: String) extends Animal
  case class Parrot(greet: String) extends Animal

  val animal: Animal = Dog("Some")

  animal match {
    case Dog(somebreed) => println(s"Dog with breed $somebreed")
    case Parrot(greet) => println(s"Parrot with greet $greet")
    case _ => "Not found"
  }


  // Exercise
  trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(expr1: Expr, expr2: Expr) extends Expr
  case class Product(expr1: Expr, expr2: Expr) extends Expr

  def show(expr: Expr): String = expr match {
    case Number(a) => s"$a"
    case Sum(a,b) => show(a) + "+" + show(b)
    case Product(a,b) => {
      def mayBeSum(exp: Expr): String = exp match {
        case Number(_) => show(exp)
        case Product(_,_) => show(exp)
        case _ => "(" + show(exp) + ")"
      }

      mayBeSum(a) + "*" + mayBeSum(b)
    }
  }

  println(show(Sum(Number(2), Number(3))))
  println(show(Product(Number(2), Number(3))))
  println(show(Product(Sum(Number(2), Number(3)), Number(4))))
  println(show(Sum(Product(Number(2), Number(3)), Number(4))))
  println(show(Product(Product(Number(2), Number(3)), Number(4))))
  println(show(Sum(Sum(Number(2), Number(3)), Number(4))))

}
