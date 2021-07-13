package Algo

object GreedyAlgo {

  def main(args: Array[String]): Unit = {
    val size = 7
    val hours = 50
    val timeArray = Array(10, 100, 4, 16, 8, 17, 28)

    val sortedArray = timeArray.sorted

    /*sortedArray.foldLeft(0, 0){(a, b) =>

      if(a._2 < hours)
      (a._1+1, a._2+b)
      else (a, b)

    }*/

    var sum = 0
    var items = 0

    sortedArray.foreach(time => {
        if(sum < hours) {
          sum += time
          items += 1
          println("sum: " + sum + "time: "+  time + "items: " + items)
        }
    })

    println("Items to be completed in given time of: " + hours + " is: " + items)

  }

}
