package rockthejvm.lectures.part02oops

object CaseClasses extends App{

  case class Person(name: String, age: Int)

  // 1. class parameters are fields
  val jim = new Person("jim", 34)
  println(jim.name)

  // 2. sensible toString implemented out of the box
  println(jim.toString)

  // 3. equals and hashcode implemented out of the box
  val jim2 = new Person("jim", 34)
  println(jim == jim)  // true, as hashcode and equals are overriden by default in scala to compare values

  // 4. case class have handy copy class
  val jim3 = jim.copy()  // same as jim
  val jim4 = jim.copy(age = 45)  // same as jim but age value changed to 45

  // 5. case classes have companion objects by default
  val thePerson = Person
  val mary = Person("Mary", 23)   // it delegates to perosn's apply method

  // 6. case class is serializable  --  helpful in distributed sys as data being sent across network

  // 7. case classs have extractor patterns = case classes can be used in Pattern matching

  // 8. case objects is same as case class, other than there is no companion object
  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }



}
