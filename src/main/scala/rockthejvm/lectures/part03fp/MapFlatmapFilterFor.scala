package rockthejvm.lectures.part03fp

object MapFlatmapFilterFor extends App{

  val numbers = List(1, 2, 3, 4)
  val chars = List('a','b','c', 'd')

  // print all combination of two list's elements
  println(numbers.map(a => chars.map(b => ""+ a + b)))
  println(numbers.flatMap(a => chars.map(b => "" + a + b ))) // replace 2 for loops by flatmap and map

  val colors = List("black", "white")
  // iterating
  val combinations = numbers.filter(_ % 2 == 0).flatMap(n => chars.flatMap(c => colors.map(color => "" + n + c + color)))
  // above is equivalent to below
  // for-comprehensions
  val forCombination = for {
    n <- numbers if n % 2 == 0
    c <- chars
    color <- colors
  } yield "" + n + c + color

  println(combinations)
  println(forCombination)

  for{
    n <- numbers
  }println(n)


}
