package rockthejvm.lectures.part03fp

import scala.util.{Failure, Random, Success, Try}

object HandlingzFailures extends App{

  // create success and failure
  val success = Success(3)
  val failure = Failure(new RuntimeException("Total failure!!"))
  println(success)
  println(failure)

  def unsafeMethod(): String = throw new RuntimeException("No String")

  // Try objects via apply method
  val potentialFailure = Try(unsafeMethod())
  println(potentialFailure)

  // syntax sugar
  val anotherUnsafeMethod = Try{
    // code that might throw exception
  }

  // utilities
  println(potentialFailure.isSuccess)
  println(potentialFailure.isFailure)

  // orElse
  def backupMethod = "A valid api"
  val fallbackTry = Try(unsafeMethod()).orElse(Try(backupMethod))
  println(fallbackTry)

  // If you design api
  val betterUnsafeApi: Try[String] = Failure(new RuntimeException)
  val betterBackupMethod: Try[String] = Success("A valid Api")
  val betterFallbackTry = betterUnsafeApi orElse betterBackupMethod

  // map, flatMap, filter
  println(success.map(_*2))
  println(success.flatMap(a => Success(a*2)))
  println(success.filter(a => a > 10))

  // Exercise
  val hostname = "localhost"
  val port = "8080"

  def renderHTML(page: String) = println(page)

  class Connection {
    def get(url: String): String = {
    val random = new Random(System.nanoTime())
      if(random.nextBoolean()) "<html>...<html>"
      else throw new RuntimeException("Connection Inturrupted!!")
    }

    def safeGet(url: String): Try[String] = Try(get(url))
  }

  object HttpService{
    val random = new Random(System.nanoTime())

    def getConnection(host: String, port:String): Connection = {
      val random = new Random(System.nanoTime())
      if(random.nextBoolean()) new Connection
      else throw new RuntimeException("port already taken!!")
    }

    def safeGetConnection(host: String, port: String): Try[Connection] = Try(getConnection(host, port))
  }

  // If I get html page from connection, call renderHTML to print

  // using flatMap function

  val possibleConnection = HttpService.safeGetConnection(hostname, port)
  val possibleHTML = possibleConnection.flatMap(con => con.safeGet("/home"))
  possibleHTML.foreach(renderHTML)

  // using shorthand

  HttpService.safeGetConnection(hostname, port)
    .flatMap(con => con.safeGet("/home"))
    .foreach(renderHTML)

  // for comprehension

  for{
    connection <- HttpService.safeGetConnection(hostname, port)
    html <- connection.safeGet("/home")
  } renderHTML(html)

}
