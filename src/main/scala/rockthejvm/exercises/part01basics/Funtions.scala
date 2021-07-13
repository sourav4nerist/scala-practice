package rockthejvm.exercises.part01basics

object Funtions extends App{

  def greetingFunction(name: String, age: Int): String = {
    s"My name is $name and I am $age years old."
  }

  def factorial(num: Int): Int = {
    if(num <= 1) 1
    else num * factorial(num - 1)
  }

  def fibonacci(num: Int): Int = {
    if(num <= 2) 1
    else fibonacci(num-1) + fibonacci(num - 2)
  }

  def isPrime(num: Int): Boolean = {
    def isPrimeUntil(denom: Int) : Boolean = {
      if (denom <= 1) true
      else (num % denom != 0) && isPrimeUntil(denom - 1)
    }
    isPrimeUntil(num/2)
  }

  println(greetingFunction("Jeff", 56))
  println(factorial(5))  // 120
  println(fibonacci(8)) // 21
  println(isPrime(37)) // true
  println(isPrime(2003)) // true
  println(isPrime(37 * 17)) // false
}
