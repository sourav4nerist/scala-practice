package rockthejvm.lectures.part02oops

object OOObasics extends App{
  val person = new Person("John", 26)
  println(person.age)
  person.greet("Daniel")

}

// constructor
class Person(name: String, val age: Int) {
  val x = 2
  println(x + 2)  // this line will be evaluated and printed every time object is created

  // method
  def greet(name: String) = println(s"${this.name} says: Hi, $name")

  // multiple constructors
  def this(name : String) = this(name, 0)  // auxiliary constructor can only call other constructor
}
// class parameters are not field, need to add keyword val to make it as field