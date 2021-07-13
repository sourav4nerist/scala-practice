package Algo

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * Problem Statement :
  * Our chef has recently opened a new restaurant with a unique style.
  * The restaurant is divided into K compartments (numbered from 1 to K) and each compartment can be occupied by at most one customer.
  * Each customer that visits the restaurant has a strongly preferred compartment p (1 ≤ p ≤ K),
  *   and if that compartment is already occupied, then the customer simply leaves.
  * Now obviously, the chef wants to maximize the total number of customers that dine at his restaurant and
  *   so he allows (or disallows) certain customers so as to achieve this task. You are to help him with this.
  * Given a list of N customers with their arrival time, departure time and the preferred compartment,
  *   you need to calculate the maximum number of customers that can dine at the restaurant.
  * Input:
  * The first line contains an integer T denoting the number of test cases.
  * Each of the next T lines contains two integers N and K ,
  * the number of customers that plan to visit the chef’s restaurant and the number of compartments the restaurant is divided into respectively.
  * Each of the next N lines contains three integers si, fi and pi , the arrival time, departure time and
  *   the strongly preferred compartment of the ith customer respectively.
  * Note that the i th customer wants to occupy the pi th compartment from [si, fi) i.e
  * the ith customer leaves just before fi so that another customer can occupy that compartment from fi onwards.
  * Output:
  * For every test case, print in a single line the maximum number of customers that dine at the restaurant.
  * Constraints:
  * 1 ≤ T ≤ 30
  * 0 ≤ N ≤ 10⁵
  * 1 ≤ K ≤ 10⁹
  * 0 ≤ si < fi ≤ 10⁹
  * 1 ≤ pi ≤ K
  * Example:
  * Input:
  * 2
  * 3 3
  * 1 3 1
  * 4 6 2
  * 7 10 3
  * 4 2
  * 10 100 1
  * 100 200 2
  * 150 500 2
  * 200 300 2
  * Output:
  * 3
  * 3
  */
object BonAppetitProblem {

  def main(args: Array[String]): Unit = {

    val test = args(0)
    var nextPosition = 1
    //val mapList = mutable.ListBuffer[mutable.Map[Int, mutable.Map[Int, Int]]]
    for(x <- 1 to test.toInt) {
      val custNum = args(nextPosition).split(",")(0).toInt
      val compartmentNum = args(nextPosition).split(",")(1).toInt
      val preferenceMap = mutable.Map[Int, ListBuffer[(Int, Int)]]()
      nextPosition += 1
      println("Test: "+ x)
      for(y <- 1 to custNum){
        val start = args(nextPosition).split(",")(0).toInt
        val end = args(nextPosition).split(",")(1).toInt
        val preference = args(nextPosition).split(",")(2).toInt
        val timeBuffer = new mutable.ListBuffer[(Int, Int)]
        val  time = (start, end)
        if(preferenceMap.contains(preference))
          timeBuffer.addAll(preferenceMap(preference))
        //else
          timeBuffer += time
        preferenceMap.put(preference, timeBuffer)
        nextPosition += 1
      }
      val keys = preferenceMap.keys
      keys.foreach(k => {
        var count = 0
        var previous = (0, 0)
        val sortedTime = preferenceMap(k).sortBy(_._2)
        sortedTime.foreach(a =>{
          if(a._1 > previous._1) {
            count += 1
            previous = a
          }

        })
        println("compartment: "+ k + " customers: "+ count)

      })
    }

  }

}
