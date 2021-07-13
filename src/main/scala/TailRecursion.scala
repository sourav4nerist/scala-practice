object TailRecursion {

  def getFibonacci(index: Int): Int = {
    def tailRec(index: Int, prev: Int, curr: Int): Int = {
      if (index <= 0)
        curr
      else
        tailRec(index-1, prev = prev + curr, curr = prev )
    }
    tailRec(index, 1, 0)

  /*  tailRec(9, 1, 1)
    tailRec(8, 2, 1)
    tailRec(7, 3, 2)
    tailRec(6, 5, 3)
    tailRec(5, 8, 5)
    tailRec(4, 13, 8)
    tailRec(3, 21, 13)
    tailRec(2, 34, 21)
    tailRec(1, 55, 34)
    tailRec(0, 89, 55)*/

  }

  def main(args: Array[String]): Unit = {
    println(getFibonacci(10))
  }
}
