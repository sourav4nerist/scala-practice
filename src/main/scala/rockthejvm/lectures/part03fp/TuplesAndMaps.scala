package rockthejvm.lectures.part03fp

object TuplesAndMaps extends App {

  // Tuples
  val tuple = (2, "Hello Scala")
  println(tuple._1)
  println(tuple.copy(_2 = "Hello Java"))
  println(tuple.swap)

  // Maps
  val map = Map((1, "Hello Scala"),2 -> "Hello Java")
    .withDefaultValue(-1) // addition of default value saves from NosuchElementException
  println(map)
  println(map.contains(2))
  println(map(0))  // prints default value

  val aNewMap = (3, "Python")
  println(map + aNewMap)

  println(map.view.filterKeys(_ < 2))
  println(map.view.mapValues(_ + "."))

  // conversion to other collection
  println(map.toList)
  val names = List("Bob", "Jim", "Anne", "John")
  println(names.groupBy(name => name.charAt(0)))

  /*
  Creating a small social netowork using Map
   */

  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    network + (person -> Set())
  }

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    def removeAux(persons: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] = {
      if(persons.isEmpty) networkAcc
      else removeAux(persons.tail, unfriend(networkAcc, person, persons.head))
    }

    val unfriended = removeAux(network(person), network)
    unfriended - person
  }

  def friend(network: Map[String, Set[String]], person1: String, person2: String): Map[String, Set[String]] = {
      val friendList1 = network(person1)
      val friendList2 = network(person2)

    network + (person1 -> (friendList1 + person2)) + (person2 -> (friendList2 + person1))
  }

  def unfriend(network: Map[String, Set[String]], person1: String, person2: String): Map[String, Set[String]] = {
    val friendList1 = network(person1)
    val friendList2 = network(person2)

    network + (person1 -> (friendList1 - person2)) + (person2 -> (friendList2 - person1))
  }


  val empty: Map[String, Set[String]] = Map()
  val network = add(add(empty, "Bob"),"Mary")
  println(network)
  println(friend(network, "Bob", "Mary"))
  println(unfriend(friend(network, "Bob", "Mary"),"Bob", "Mary"))
  println(remove(friend(network, "Bob", "Mary"),"Bob"))

  // Jim, Bob, Mary
  val people = add(add(add(empty, "Bob"),"Mary"),"Jim")
  val jimBob = friend(people,"Jim", "Bob")
  val testNet = friend(jimBob, "Bob","Mary")

  println(testNet)

  def numFriends(network: Map[String, Set[String]], person: String): Int= {
    if(!network.contains(person)) 0
    else network(person).size
  }

  println(numFriends(testNet, "Bob"))

  def personWithMostFrnds(network: Map[String, Set[String]]): String= {
    network.maxBy(pair => pair._2.size)._1
  }

  println(personWithMostFrnds(testNet))

  def noFriends(network: Map[String, Set[String]]): Int= {
    network.count(_._2.isEmpty)
  }

  println(noFriends(testNet))

  def isSocialConnection(network: Map[String, Set[String]], person1: String, person2: String): Boolean = {
    def bfs(target: String, consideredPeople: Set[String], discoveredPeople: Set[String]): Boolean = {
      if(discoveredPeople.isEmpty) false
      else{
        val person = discoveredPeople.head
        if(target.equals(person)) true
        else if (consideredPeople.contains(person)) bfs(target, consideredPeople, discoveredPeople.tail)
        else bfs(target, consideredPeople + person, discoveredPeople.tail ++ network(person))
      }
    }

    bfs(person2, Set(), network(person1) + person1)
  }

  println(isSocialConnection(testNet, "Mary", "Jim"))
  println(isSocialConnection(network, "Mary", "Bob"))

}
