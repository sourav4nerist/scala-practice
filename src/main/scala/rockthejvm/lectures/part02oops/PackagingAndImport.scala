package rockthejvm.lectures.part02oops

import rockthejvm.exercises.part02basics.Writer
import java.util.Date
import java.sql.{Date => SQLDate}

object PackagingAndImport extends App{

  // package members are accessible by their simple name
  val writer = new Writer("Sourav", "Kumar", 30)

  // if class used is not in the same package,
  // then we need to import the package or call class by fully qualified name


  // package object
  // methods, constant in package object can be accessed across package
  sayHello
  println(SPEED_OF_LIGHT)

  // package aliasing
  val date = new Date    // by default, it resolves to first import Date i.e. java.util.Date

  // to use sql date
  // 1 way - by using fully qualified name
  //val sqlDate = new java.sql.Date()

  // 2nd way - by using aliasing
  val sqlDate = new SQLDate(2020,5,23)

  //default imports
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.Predef - println, ???



}
