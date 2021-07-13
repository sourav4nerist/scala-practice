package rockthejvm.lectures.part02oops

object Inheritance extends App{

  // Scala has single class inheritance as in Java
  class Animal{
    val creatureType = "Wild"
    def eat = println("Eat")
    protected def crunch = println("Crunch")
  }

  class Cat extends Animal

  val cat = new Cat
  cat.eat

  class Dog extends Animal{
    override val creatureType: String = "Domestic"
    override def crunch: Unit = println("crunchcrunch")
  }

  // we can also override a value as below
  /*
  class Dog(override val creatureType: String) extends Animal{
    override def crunch: Unit = println("crunchcrunch")
  }

  or

  class Dog(type: String) extends Animal{
  override val creatureType: String = type
    override def crunch: Unit = println("crunchcrunch")
  }
   */

  val dog = new Dog
  dog.crunch
  println(dog.creatureType)

/* preventing overrides
1. Use of final keyword in front of method
2. final can be used on class, then class can not be inherited,
      existing String or Numerical classes are final in scala
3. seal the class using keyword 'sealed' in front of class declaration -
      extend the class in this file but prevents extension in other files.
      Used when we know classes that will extend the sealed class upfront and are available in the same file
*/
}
