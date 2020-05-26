package basic

import scala.collection.mutable.ArrayBuffer


object demo_12 {

  private val a = 3
  def main(args: Array[String]): Unit = {
    val res = for (i <- 1 to 10) yield i
    println(res)

    val list_1 = new Array[String](3)
    //    val days = List()
    // Make a list via the companion object factory
    val days = List("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
    // Make a list element-by-element
    val when = "AM" :: "PM" :: List()
    println(when)

    // Pattern match
    //    days match {
    //      case firstDay :: otherDays :: otherdays =>
    //        println("The first day of the week is: " + firstDay)
    //        println(firstDay)
    //        println(otherDays)
    //        println(otherdays)
    //      case List() =>
    //        println("There don't seem to be any week days.")
    //    }
    //

    def add = {
      "srr"
    }

    val f1 = 3 + 4

    val add_f = (a: Int, b: Int) => a + b

    def toList[T](i: Map[String, T]) = {

    }

    def m(f: (Int, Int) => Int): Int = {
      f(2, 6)
    }




    val a: ((Int, Int) => Int) => Int = m


    println(add_f(3, 4))

    val inclusive = 0 to 10
    println(inclusive)
    for (i <- Array("a", "b", "c")) println(i)

    val unit = for (i <- 1 to 3; j <- 1 to 3 if i != j) yield (10 * i + j)
    println(unit)
    var y = 0
    val result = for {i <- 1 to 3
                      j <- 1 to 3
                      if i != j
                      } yield (10 * i + j)
    println(result)


    val parttern = "a"
    val patern = parttern match {
      case "a" => "匹配成功"
      //      case "a" =>println("匹配成功")
      case _ => println("？？")
    }
    println(patern)

//    println(a)


  }
}

object BlockExpressionDemo {
  def main(args: Array[String]) {
    val a = 10
    val b = 20
    //在scala中{}中包含一系列表达式，块中最后一个表达式的值就是块的值
    //下面就是一个块表达式
    val result = {
      val c = b - a
      val d = b - c
      d //块中最后一个表达式的值
    }
    //result的值就是块表达式的结果
    println(result)


  }
}

