package rockthejvm.lectures.part03fp

import scala.util.Random

object Sequences extends App{

  // Seq
  val seq = Seq(1,2,3,5,4)
  println(seq)
  println(seq(2)) // equivalent to seq.applly()
  println(seq ++ Seq(6,7,8))
  println(seq.sorted)

  // Range
  val aRange: Seq[Int] = 1 to 10
  val anotherRange: Seq[Int] = 1 until 10

  aRange.foreach(println)
  anotherRange.foreach(println)

  // List
  val aList = List(1,2,3)
  val prepend = 42 :: aList
  val prePost = 33 +: aList :+ 44
  println(prepend)
  println(prePost)

  val apple5 = List.fill(5)("apple")
  println(apple5)
  println(aList.mkString("-"))

  //Array

  val mkArrays = Array(1,2,3)
  val threeArray = Array.ofDim[Integer](3)
  println(mkArrays)
  threeArray.foreach(println)

  threeArray(2) = 0
  println(mkArrays.mkString(" "))

  // Vectors
  val vector: Vector[Int] = Vector(1,2,3)
  println(vector)

  // Vector vs list performance: Vector have better performance

  val maxRuns = 1000
  val maxCapacity = 1000000

  def getWriteTime(collection: Seq[Int]) : Double = {
    val r = new Random
    val times = for{
      it <- 1 to maxRuns
    } yield {
      val currTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currTime
    }

    times.sum * 1.0 /maxRuns
  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  println(getWriteTime(numbersList))
  println(getWriteTime(numbersVector))

}
