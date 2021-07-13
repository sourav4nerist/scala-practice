package rockthejvm.exercises.part01basics

object CBNvsCBV extends App{
  def callByValue(x: Long): Unit = {
    println("by value:" + x)  // call by value, first computes x from expression System.nanoTime()
    println("by value:" + x)  // and then uses the same computed value both the times
  }

  def callByName(x: => Long): Unit ={   // => is used to designate call by name
    println("by name:" + x)  // call by name replaces every occurrence of x
    println("by name:" + x)  // by actual expression System.nanoTime().
                            // hence we have different output both times
                            // in call by name, expression is evaluated only when used (lazy evaluation)
  }

  callByValue(System.nanoTime())
  callByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  //printFirst(infinite(), 34) // this will throw stackOverflowException
  printFirst(34, infinite())  // this executes without stackOverflowException,
                              // because call by name is evaluated only when used
}
