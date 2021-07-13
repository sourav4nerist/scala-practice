package rockthejvm.lectures.part02oops

object AnonymousClasses extends App {

  abstract class Animal{
    def eat: Unit
  }

  // below code, instantiates anonymous class that extends Animal abstract class
  // abstract class cannot be instantiated
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("hahaha")
  }

  /*
  Equivalent to:

  class AnonymousClasses$$anon$1 extends Animal{
    override def eat: Unit = println("hahaha")
  }

  val funnyAnimal: Animal = new AnonymousClasses$$anon$1
   */

  println(funnyAnimal.getClass) // prints Anonymous class instance

  class Person(name: String){
    def hi = println("Hi, I am Person")
  }

  // Anonymous class works for traits, abstract and non abstract classes
  val anonPerson = new Person(""){
    override def hi = println("Hi, I am anonymous Person")
  }
}
