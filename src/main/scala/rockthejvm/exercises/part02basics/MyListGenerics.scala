package rockthejvm.exercises.part02basics

import scala.annotation.tailrec
import scala.runtime.Nothing$

abstract class MyListGenerics[+A] {
  def head: A
  def tail: MyListGenerics[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyListGenerics[B]
  def printElements: String
  // polymorphic call, need to override as it's defined in Any class
  override def toString: String = "[" + printElements + "]"

  def reverse: MyListGenerics[A]

  // Higher order function - either receives function as parameters or returns back a function
  def map[B](transformer: A => B): MyListGenerics[B]
  def flatMap[B](transformer: A => MyListGenerics[B]): MyListGenerics[B]
  def filter(predicate: A => Boolean):MyListGenerics[A]

  // Concatenation
  def ++[B >: A] (list: MyListGenerics[B]): MyListGenerics[B]

  // HOFS
  def foreach(f: A => Unit): Unit
  def sort(compare: (A, A) => Int): MyListGenerics[A]
  def zipWith[B, C](list: MyListGenerics[B], func: (A, B) => C): MyListGenerics[C]
  def fold[B](start: B)(operator: (A,B) => B): B

}


case object EmptyGenerics extends MyListGenerics[Nothing]{
  def head: Nothing = throw new NoSuchElementException
  def tail: MyListGenerics[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyListGenerics[B] = new ConsGenerics(element, EmptyGenerics)

  override def printElements: String = ""

  def reverse: MyListGenerics[Nothing] = EmptyGenerics

  def map[B](transformer: Nothing => B): MyListGenerics[B] = EmptyGenerics
  def flatMap[B](transformer: Nothing => MyListGenerics[B]): MyListGenerics[B] = EmptyGenerics
  def filter(predicate: Nothing => Boolean):MyListGenerics[Nothing] = EmptyGenerics

  def ++[B >: Nothing](list: MyListGenerics[B]):MyListGenerics[B] = list

  // HOFS
  def foreach(f: Nothing => Unit): Unit = ()
  def sort(compare: (Nothing, Nothing) => Int): MyListGenerics[Nothing] = EmptyGenerics
  def zipWith[B, C](list: MyListGenerics[B], func:(Nothing, B) => C): MyListGenerics[C] = {
    if(!list.isEmpty) throw new RuntimeException("Lists do not have same length")
    else EmptyGenerics
  }
  def fold[B](start: B)(operator: (Nothing,B) => B): B = start
}

case class ConsGenerics[+A](h: A, t: MyListGenerics[A]) extends MyListGenerics[A]{
  def head: A = h
  def tail: MyListGenerics[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyListGenerics[B] = new ConsGenerics(element, this)
  override def printElements: String =
    if (t.isEmpty) h.toString
    else h + "," + t.printElements

  def reverse: MyListGenerics[A] = {

    @tailrec
    def reverseTR(input: MyListGenerics[A], acc: MyListGenerics[A]): MyListGenerics[A] = {
      if (input.isEmpty) acc
      else reverseTR(input.tail, new ConsGenerics[A](input.head, acc))
    }

    reverseTR(this, EmptyGenerics)
  }

  def map[B](transformer: A => B): MyListGenerics[B] = {
    new ConsGenerics(transformer(h),t.map(transformer))
  }
  def flatMap[B](transformer: A => MyListGenerics[B]): MyListGenerics[B] = {
    transformer(h) ++ t.flatMap(transformer)
  }
  def filter(predicate: A => Boolean):MyListGenerics[A] = {
    if(predicate(h)) new ConsGenerics(h, t.filter(predicate))
    else t.filter(predicate)
  }

  def ++[B >: A](list: MyListGenerics[B]):MyListGenerics[B] = new ConsGenerics(h,t ++ list)

  // HOFS
  def foreach(f: A => Unit):Unit = {
    f(h)
    t.foreach(f)
  }

  /*def sort(compare: (A, A) => Int): MyListGenerics[A] = {

    def insert(x: A, sortedTail: MyListGenerics[A]): MyListGenerics[A] = {
      if(sortedTail.isEmpty) new ConsGenerics[A](x, EmptyGenerics)
      else if(compare(x, sortedTail.head) <= 0) new ConsGenerics[A](x, sortedTail)
      else new ConsGenerics(sortedTail.head, insert(x, sortedTail.tail))
    }

    val sortedTail = t.sort(compare)
    insert(h, sortedTail)
  }*/

  def sort(compare: (A, A) => Int): MyListGenerics[A] = {

    @tailrec
    def insert(x: A, sortedTail: MyListGenerics[A], previousList: MyListGenerics[A]): MyListGenerics[A] = {
      if(sortedTail.isEmpty || compare(x, sortedTail.head) <= 0) new ConsGenerics[A](x, previousList).reverse ++ sortedTail
      else insert(x, sortedTail.tail, new ConsGenerics[A](sortedTail.head, previousList))
    }

    @tailrec
    def sortTR(input: MyListGenerics[A], acc: MyListGenerics[A]): MyListGenerics[A] = {
    if(input.isEmpty) acc
    else sortTR(input.tail, insert(input.head, acc, EmptyGenerics))
    }

    sortTR(this, EmptyGenerics)
  }

  def zipWith[B, C](list: MyListGenerics[B], func: (A, B) => C): MyListGenerics[C] = {
    if(list.isEmpty) throw new RuntimeException("Lists do not have same length")
    else new ConsGenerics[C](func(h,list.head),t.zipWith(list.tail, func))
  }

  def fold[B](start: B)(operator: (A,B) => B): B = {
    tail.fold(operator(head, start)) (operator)
  }
}

object ListTestGenerics extends App{
  val listOfInt: MyListGenerics[Int] = new ConsGenerics(1, new ConsGenerics(2, new ConsGenerics(3, EmptyGenerics)))
  val clonedListOfInt: MyListGenerics[Int] = new ConsGenerics(1, new ConsGenerics(2, new ConsGenerics(3, EmptyGenerics)))
  val listOfString: MyListGenerics[String] = new ConsGenerics("A", new ConsGenerics("B", new ConsGenerics("C", EmptyGenerics)))
  val anotherListOfInt: MyListGenerics[Int] = new ConsGenerics(4, new ConsGenerics(5, new ConsGenerics(6, EmptyGenerics)))

  println(listOfInt)
  println(listOfString)

  println(listOfInt.map(new Function1[Int, Int] {
    override def apply(elem: Int): Int = elem * 2
  }).toString)

  println(listOfInt.filter(new Function1[Int, Boolean] {
    override def apply(element: Int): Boolean = element < 2
  }).toString)

  println((listOfInt ++ anotherListOfInt).toString)

  println(listOfInt.flatMap(new Function1[Int, MyListGenerics[Int]] {
    override def apply(elem: Int): MyListGenerics[Int] = new ConsGenerics(elem, new ConsGenerics(elem+1, EmptyGenerics))
  }))

  println(clonedListOfInt == listOfInt)

  listOfInt.foreach(x => println(x))

  println(listOfInt.sort((x,y) => x-y))

  println(clonedListOfInt.zipWith[String, String](listOfString, (x,y) => x +  y))

  println(listOfInt.fold(0)(_+_))

  // for- comprehensions
  for{
    n <- listOfInt
    c <- listOfString
  } yield "" + n + c
}
