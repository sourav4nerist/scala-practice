package Algo

import scala.collection.mutable

object PickingUpChicksProblem {

  def main(args: Array[String]): Unit ={

    val testCases = args(0).toInt
    var lineNum = 1
    for(x <- 1 to testCases){
      val totalChicks = args(lineNum).split(",")(0).toInt
      val chickToReachBarn = args(lineNum).split(",")(1).toInt
      val barnLoc = args(lineNum).split(",")(2).toInt
      val timeToReachBarn = args(lineNum).split(",")(3).toInt

      lineNum += 1
      val initialLoc = args(lineNum).split(",")
      lineNum += 1
      val speed = args(lineNum).split(",")

      val chickCanReach = new mutable.ListBuffer[(Int, Int)]
      val chickCanReachBarn = new mutable.ListBuffer[Boolean]

      for(y <- 0 until totalChicks){
        if(initialLoc(y).toInt + (speed(y).toInt*timeToReachBarn) >= barnLoc) {
          val locTimeTuple = (initialLoc(y).toInt, speed(y).toInt)
          chickCanReach += (locTimeTuple)
          chickCanReachBarn += true
        }
        else
          chickCanReachBarn += false
      }
      if(chickCanReach.size < chickToReachBarn)
        println("Case#" +x +":" + "IMPOSSIBLE")
      else {
        var swap = 0
        var possibleSwap = 0
        for(a <- 0 until chickCanReachBarn.size){
          if(chickCanReachBarn(a)){
            swap += possibleSwap
          }
          else
            possibleSwap += 1
        }
        /*chickCanReach.foreach( chickTuple => {
          var locReach = chickTuple._1
          val speedReach = chickTuple._2
          for(a <- 0 until totalChicks){
            val speedEachChick = speed(a).toInt
            var locEachChick = initialLoc(a).toInt
            if(locReach < barnLoc && locEachChick< barnLoc) {
                for (t <- 1 to timeToReachBarn) {
                  locEachChick += locEachChick + speedEachChick
                  locReach += locReach + speedReach
                  if(locReach < barnLoc && locEachChick == locReach)
                    swap += 1
                }
            }

          }

        })*/
        println("Case#" +x +":" +swap)
      }
      // Increase to location for next test case
      lineNum += 1
    }
  }

}
