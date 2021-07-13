package rockthejvm.lectures.part03fp

import scala.util.Random

object Options extends App{

  val myFirstOption: Option[Int] = Some(4)
  val noOption:Option[Int] = None

  println(myFirstOption)

  // work with unsafe api
  def unsafeApi(): String = null
  val result = Option(unsafeApi())
  println(result)

  def backupApi: String = "A valid result"
  val chainedResult = Option(unsafeApi()).orElse(Option(backupApi))

  // Better designed unsafe API
  def betterUnsafeApi: Option[String] = None
  def betterBackupApi: Option[String] = Some("A better result")
  val betterChainedResult = betterUnsafeApi orElse betterBackupApi
  println(betterChainedResult)

  // Functions on Options
  println(myFirstOption.isEmpty)
  println(myFirstOption.get) // unsafe, should not be used as can return null

  // map, flatmap, filter
  println(myFirstOption.map(_*2))
  println(myFirstOption.filter(_ > 10))
  println(myFirstOption.flatMap(x => Option(x * 10)))

  val config = Map(
    "host" -> "176.42.36.1",
    "port" -> "80"
  )

  class Connection{
    def connect() = "Connected"
  }

  object Connection{
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] = {
      if (random.nextBoolean()) Some(new Connection)
      else None
    }
  }

  val host = config.get("host")
  val port = config.get("port")
/*
if (h!= null)
  if (p!= null)
    return Connection.apply(h,p)
else
  return null
 */
  val connection = host.flatMap(h => port.flatMap(p => Connection(h,p)))
  /*
  if (c!= null)
    return c.connect()
  else
    return null
   */
  val connectionStatus = connection.map(c => c.connect())
  // if(connectionStatus == null) println(None) else println(Some(connectionStatus.get()))
  println(connectionStatus)
  /*
  if(status != null)
    println(status)
   */
  connectionStatus.foreach(println)

  // chained calls
  config.get("host")
    .flatMap(h => config.get("port")
    .flatMap(p => Connection(h,p))
    .map(_.connect()))
    .foreach(println)

  // for comprehensions

  val forConnectionStatus = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield connection.connect()

  forConnectionStatus.foreach(println)

}
