package rockthejvm.exercises.part02basics

abstract class MyList {

  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(element: Int): MyList
  def printElements: String
// polymorphic call, need to override as it's defined in Any class
  override def toString: String = "[" + printElements + "]"

}

object Empty extends MyList{
  def head: Int = throw new NoSuchElementException
  def tail: MyList = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(element: Int): MyList = new Cons(element, Empty)

  override def printElements: String = ""
}

class Cons(h: Int, t: MyList) extends MyList{
  def head: Int = h
  def tail: MyList = t
  def isEmpty: Boolean = false
  def add(element: Int): MyList = new Cons(element, this)
  override def printElements: String =
    if (t.isEmpty) h.toString
    else h + "," + t.printElements
}

object ListTest extends App{
  val list = new Cons(1, Empty)
  println(list.head)
  println(list.toString)

  val list1 = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list1.tail.head)
  println(list1.isEmpty)
  println(list1.toString)

  println(list1.add(4).head)
}
