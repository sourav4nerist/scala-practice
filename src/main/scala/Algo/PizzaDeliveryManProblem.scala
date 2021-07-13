package Algo

import java.util.ArrayList

import scala.collection.mutable.ListBuffer

/**
  * Problem Statement :
  * Andy and Bob are the only two delivery men of Pizza-chef store. Today, the store received N orders.
  * It’s known that the amount of tips may be different when handled by different delivery man.
  * More specifically, if Andy takes the ith order, he would be tipped Ai dollars and if Bob takes this order,
  * the tip would be Bi dollars.
  * They decided that they would distribute the orders among themselves to maximize the total tip money.
  * One order will be handled by only one person.
  * Also, due to time constraints Andy cannot take more than X orders and Bob cannot take more than Y orders.
  * It is guaranteed that X + Y is greater than or equal to N,
  *   which means that all the orders can be handled by either Andy or Bob.
  * Please find out the maximum possible amount of total tip money after processing all the orders.
  *
  * Input:
  * The first line contains three integers N, X, Y.
  * The second line contains N integers. The ith integer represents Ai.
  * The third line contains N integers. The ith integer represents Bi.
  *
  * Output:
  * Print a single integer representing the maximum tip money they would receive.
  * Constraints; all tests :
  * 1 ≤ N ≤ 10⁵
  * 1 ≤ X, Y ≤ N; X + Y ≥ N
  * 1 ≤ Ai, Bi ≤ 10⁴
  * Example:
  * Input -
  * 5 3 3
  * 1 2 3 4 5
  * 5 4 3 2 1
  * Output -
  * 21
  */
object PizzaDeliveryManProblem {

  def main(args: Array[String]): Unit = {

    val totalOrders = 5
    val andyOrders = 5
    val bobOrders = 5
    val andyTips = List (1, 2, 3, 4, 5)
    val bobTips = List (5, 4, 3, 2, 1)

    val output = getMaxTip(totalOrders, andyOrders, bobOrders, andyTips, bobTips)

    println("Total tips amount: " + output._1)
    println("Andy order number" + output._2)
    println("Bob order number" + output._3)


  }

  def getMaxTip(totalOrders: Int, andyOrders: Int, bobOrders: Int, andyTips: List[Int], bobTips: List[Int]): (Int, ListBuffer[Int], ListBuffer[Int]) = {
    val andyOrderNo = new ListBuffer[Int]
    val bobOrderNo = new ListBuffer[Int]
    var total = 0
    for(x <- 0 until andyTips.size){
        if(andyTips(x) > bobTips(x)){
          total +=  andyTips(x)
          andyOrderNo += x+1
        }
        else{
          total += bobTips(x)
          bobOrderNo += x+1
        }
      }
    (total, andyOrderNo, bobOrderNo)
  }

}
