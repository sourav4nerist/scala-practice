package rockthejvm.lectures.part01basics

object Expressions extends App{

  val x = 1 + 2     // Expressions

  println(2 + 3 * 4)
  // Math operators: + - * / & | ^ << >> >>> (right shift with zero extension)

  println( 1 == x)
  // Relational operators: == != > >= < <=

  println(!(1 == x))
  // Boolean operators: ! && ||

  var aVariable = 2
  aVariable += 3
  // modify and re-assignment operators: += -= *= /= ........... these are side effects
  println(aVariable)

  // Instructions (to DO) vs Expressions (computes to a VALUE)
  // Instructions are executed (if in Java) vs Expressions are evaluated (if in Scala)

  val aCondition = true
  val aConditionValue = if(aCondition) 5 else 3   // IF is an expression

  var i = 0
  val aWhile = while(i < 10){
    println(i)
    i += 1
  }

  // NEVER WRITE THIS AGAIN -- these have side effects, very bad practise for a scala developer
  // these are of imperative programming

  val aUnitValue = aVariable = 4  // Unit === void

  // Side Effects in scala : Any expression returning a Unit
  // Ex. println(), while loop, reassigning

  // Code blocks
  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if(z > 2) "hello" else "goodBye" // No need of a return, last expression is evaluated as return by default
  }

  /**
  Questions:
    1. Difference between "hello world" vs println("hello world")
    Ans: first one's type is String whereas second one's type is Unit and it's a side effect

    **/
}
