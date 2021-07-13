package rockthejvm.exercises.part02basics

object OOObasics {

  val author = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)
  val novel =  new Novel("Great Expectations", 1861, author)

  println(novel.authorAge)
  println(novel.isWrittenBy(imposter))

  val counter = new Counter
  counter.increment.print
  counter.increment.increment.increment.print
  counter.increment(10).print

}

class Novel(name: String, yearOfRelease: Int, author: Writer){
  def authorAge: Int = yearOfRelease - author.year

  def isWrittenBy(author: Writer): Boolean = author == this.author

  def copy(newYearOfRelease: Int): Novel = new Novel(name, newYearOfRelease, author)
}

class Writer(firstName: String, surName: String, val year: Int){
  def fullName: String = s"$firstName $surName"
}

class Counter(val x: Int = 0){
  def currentCount: Int = x

  // immutability, whenever any instance needs to be modified
  // we must return a completely new instance in place of
  // changing values of existing instance.
  def increment: Counter = {
    println("incrementing")
    new Counter(x + 1)
  }

  def decrement: Counter = {
    println("decrementing")
    new Counter(x - 1)
  }

  def increment(incrementBy: Int): Counter = {
    if(incrementBy <= 0 ) this
    else increment.increment(incrementBy-1)
  }

  def decrement(decrementBy: Int): Counter = {
    if(decrementBy <= 0 ) this
    else decrement.decrement(decrementBy - 1)
  }

  def print = println(currentCount)

}
