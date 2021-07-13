package rockthejvm.lectures.part01basics

object Functions extends App{
  def aFunction(a: String , b: Int) = {
    a + "" + b
  }

  println(aFunction("am", 3))

  // Recursive Function
  // It always needs a result/return type to be declared up front in signature
  // IN FUNCTIONAL PROGRAMMING, ALWAYS USE RECURSION IN PLACE OF LOOPS

  def aRecursiveFunction(a: String, b: Int): String = {
    if(b == 1) a
    else a + aRecursiveFunction(a, b-1)
  }

  println(aRecursiveFunction("hello", 3))

  // We can define a function inside a function, auxiliary functions

  def aBigFunction(a: Int) : Int = {
    def aInnerFunction(x: Int, y: Int) = x + y

    aInnerFunction(a, a-1)
  }
}
