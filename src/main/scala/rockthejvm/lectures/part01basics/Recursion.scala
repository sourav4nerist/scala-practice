package rockthejvm.lectures.part01basics

import scala.annotation.tailrec

object Recursion extends App{

  def factorial(n: Int): Int = {
    if(n <= 1) 1
    else {
      println("Computing factorial of :" + n + ", First computing factrial of : " + (n-1))
      val result = n * factorial(n-1)
      println("computed factoria of : " + n)
      result
    }
  }
  println(factorial(10))

  def anotherFactorial(n : Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt = {
      if(x <= 1) accumulator
      else factHelper(x-1, x * accumulator)   // TAIL RECURSION = use recursive call as the last expression
    }

    factHelper(n, 1)
  }

  println(anotherFactorial(5000))

}
