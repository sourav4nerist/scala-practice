package rockthejvm.lectures.part01basics

object DefaultArgs extends App{
def factorial(n: Int, acc: Int = 1): Int = {  // we can pass default values, only to the last of arguments
  if(n <= 1) acc
  else factorial(n-1, n * acc)
}
  println(factorial(10))

  def savePicture(format: String = "jpg", width: Int = 800, height: Int = 1000) =
    println("saving pictures")

  /*
  1. pass in every leading arguments
  2. name the argument, that can be in different sequence
   */

  //1. Ex
  savePicture()
  savePicture("png")
  savePicture("png",800)
  //savePicture(200) // not allowed, by default method takes argument by sequence

 //2. Ex
  savePicture(height = 600, width = 200, format = "png")


}
