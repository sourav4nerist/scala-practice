package rockthejvm.playground

object Objects extends App{

  // Scala does not have class level functionality like 'static'
  // object can not have arguments
  // Below declaration means Person is of type Person i.e. Person is an instance as well as a type
  object Person{
    // "static/class" level functionality
    val N_EYES = 2
    def canFly: Boolean = false // methods can have arguments

    def apply(mother: Person, father: Person) = new Person("Bobby")

  }

  // Companions - writing class and objects with same name in same scope
  // access to any variable or method can only be done using an instance be it regular or singleton
  // as there is no static declaration allowed, that is true OOP feature
  class Person(val name: String){
    // "instance" level functionality
  }

  println(Person.N_EYES)
  println(Person.canFly)

  // Scala object = Singleton instance
  val mary = Person
  val john = Person
  println(mary == john) // true, as both points to same instance

  val ram = new Person("Ram")
  val rita = new Person("Rita")
  println(ram == rita) // false, as both points to different instance

  val bobby = Person(ram, rita)

  // Scala applications is only a Scala object with
  // def main(args: Array[String]): Unit

}
