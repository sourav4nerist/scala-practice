package rockthejvm.lectures.part02oops

object Exceptions extends App{

 // val aWeirdValue = throw new NullPointerException

  def getInt(withException: Boolean): Int = {
    if(withException)
      throw new RuntimeException("No int for you")
    else
      42
  }

  val potentialFail = try{
    getInt(true)
  } catch {
    // case e: RuntimeException => println("caught runtime exception!")
    case e: RuntimeException => 43
  } finally {
    // code that will get executed no matter what
    // is optional
    // does not influence return of expression
    println("finally")
  }

  println(potentialFail)


  // Custom Exception
  class MyException extends Exception

  val exception = new MyException

  //throw exception

  // StackOverflowError()
  // def infinte:Int = 1 + infinte
  // val noLimit = infinte

  // OutOfMemoryError()
  // val array = Array.ofDim(Int.MaxValue)

  class OverFlowException extends RuntimeException
  class UnderFlowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by zero")
  object PocketCalculator{
    def add (a: Int, b: Int) = {
      val result = a+b
      if(a > 0 && b > 0 && result < 0) throw new OverFlowException
      else if(a < 0 && b < 0 && result > 0) throw new UnderFlowException
      else result
    }
    def subtract (a: Int, b: Int) = {
      val result = a-b
      if(a < 0 && b > 0 && result > 0) throw new UnderFlowException
      else if(a > 0 && b < 0 && result < 0) throw new OverFlowException
      else result
    }
    def multiply (a: Int, b: Int) = {
      val result = a*b
      if(a > 0 && b > 0 && result < 0 ) throw new OverFlowException
      else if(a < 0 && b < 0 && result < 0 ) throw new OverFlowException
      else if (a > 0 && b < 0 && result > 0) throw new UnderFlowException
      else if (a < 0 && b > 0 && result > 0) throw new UnderFlowException
      else result
    }
    def divide (a: Int, b: Int) = {
      if(b == 0) throw new MathCalculationException
      else a/b
    }
  }

  println(PocketCalculator.divide(2, 0))

}
