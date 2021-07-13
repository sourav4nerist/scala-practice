package rockthejvm.lectures.part01basics

object StringOps extends App{

  // s interpolation
  val name = "David"
  val age = 12
  println(s"my name is $name, my age is $age")
  println(s"may name is $name, I am turning ${age + 1}")

  // f interpolation
  val speed = 1.2f
  println(f"$name can eat $speed%2.2f burgers per minute")

  // raw interpolator
  println(raw"this \n is for a new line")
  val escaped = "this \n is for a new line"
  println(raw"$escaped")
}
