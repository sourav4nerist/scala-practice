package rockthejvm.exercises.part01basics

import scala.annotation.tailrec

object Recursion extends App{

  def stringConcat(str: String, n: Int): String = {
    @tailrec
    def stringConcatHelper(x: String, n: Int, acc: String): String = {
      if(n == 1) acc
      else stringConcatHelper(x, n-1, acc + x)
    }

    stringConcatHelper(str, n, str)
  }

  def isPrime(n: Int): Boolean = {

    @tailrec
    def isPrimeUntil(x: Int, isStillPrime: Boolean): Boolean = {
      if(!isStillPrime) false
      else if (x <= 1) true
      else isPrimeUntil(x-1, n % x != 0 && isStillPrime)
    }

    isPrimeUntil(n/2, true)
  }

  def fibonnaci(n: Int): Int = {
    @tailrec
    def fibonacciTailRec(x: Int, last: Int, nextToLast: Int): Int = {
      if(x >= n) last
      else fibonacciTailRec(x+1, last + nextToLast, last)
    }

    if(n <= 2) 1
    else fibonacciTailRec(2, 1, 1)
  }

  println(stringConcat("a:", 10))
  println(isPrime( 11))
  println(fibonnaci(8))
}
