package rockthejvm.lectures.part02oops

object Generics extends App{

  // A is a placeholder for a type
  // Generic declaration is applicable to Traits as well
  class MyList[+A] {
    // use the type A
    def add[B >: A](element: B): MyList[B] = ???
    /*
    A = Cat
    B = Dog, which is of type Animal
    So, adding a Dog to a list of Cat will return a list of Animals
     */
  }

  class MyMap[Key, Value]

  val listInt  = new MyList[Int]
  val listString = new MyList[String]

  object MyList{
    def empty[A]: MyList[A] = ???

  }

  val listOfEmptyInt = MyList.empty[Int]

  // Variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. yes, List[Cat] extends List[Animal] = COVARIANCE
  class Covariant[+A]
  val animal:Animal = new Cat
  val animalList:Covariant[Animal] = new Covariant[Cat]
  // animalList.add(new Dog) ??? HARD QUESTION => we return a list of Animals

  // 2. NO - INVARIANCE
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]
  // Not allowed, val invariantAnimalList: InvariantList[Animal] = new InvariantList[Cat]

  // 3. Hell, No! = CONTRAVARIANCE
  class ContravariantList[-A]
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]
  // Another Example:
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // Bounded Type
  // Below class can accept of Animal subtype only, this is upper bound type
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)

  class Car
  // below line not allowed, this is compilation error
  // val newCage = new Cage(new Car)

  // Below class can accept of Animal supertype only, lower bound type
  class food[A >: Animal](animal: A)

}
