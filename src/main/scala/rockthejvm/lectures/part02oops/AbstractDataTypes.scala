package rockthejvm.lectures.part02oops

object AbstractDataTypes extends App{

  // abstract -- when there is no definition of method or value/variable

  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }

  class Dog extends Animal{
    override val creatureType:String = "canine"
    def eat = println("crunch")  // override is optional when overriding value or methods of abstract class
  }

  trait Carnivore{
    def eat(animal: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    override val creatureType: String = "canine"
    def eat = println("crunch")

    override def eat(animal: Animal): Unit = println(s"I am a croc, and I am eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile

  croc.eat(dog)

  /*
  Traits vs Abstract classes

  1. traits do not have constructor parameters
  2. multiple traits may be inherited by same class
  3. traits are behaviour but an abstract class is a type of "thing"
   */

}
