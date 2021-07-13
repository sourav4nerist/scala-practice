package rockthejvm.lectures.part01basics

object ValuesVariableTypes extends App{

  //Values
  val x = 42           // val is immutable, can't be reassigned
  println(x)

  val aString: String = "Hello"
  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val aInt: Int = x
  val aShort: Short = 123
  val aLong: Long = 12345678901234L
  val aFloat: Float = 2.0f
  val aDouble:Double = 2.0

  //Variables
  var aVariable:Int = 4       // var are mutable and can have side effects
}
