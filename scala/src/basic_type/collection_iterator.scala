package basic_type

import scala.collection.immutable

object collection_iterator extends App {
  //数组
  val array: Array[Int] = Array(1, 2, 3)
  for (elem <- array) println(elem)

  val array_1: Array[Int] = array.map(_ + 1)

  //
  val list = List("i love program", "i can program with java", "i can program with scala", "i can program with python")
  private val list1: List[Array[String]] = list.map(_.split(" "))
  //  for (elem <- list1;i <- elem if i !="i") print(i+"  ")
  println(list1.mkString("  "))
  private val flatten: List[String] = list1.flatten
  println(flatten.mkString("  "))
  private val tuples: List[(String, Int)] = flatten.map((_, 1))
  println(tuples.mkString("  "))
  private val stringToTuples: Map[String, List[(String, Int)]] = tuples.groupBy(_._1)

  println(stringToTuples.mkString("  "))
  //  List((program,1), (program,1), (program,1), (program,1)) i -> List((i,1), (i,1), (i,1), (i,1)) java -> List((java,1)) can -> List((can,1), (can,1), (can,1)) love -> List((love,1))
  //  scala -> List((scala,1)) with -> List((with,1), (with,1), (with,1)) python -> List((python,1))
//  println(stringToTuples.mkString(" "))
  private val stringToInt: Map[String, Int] = stringToTuples.mapValues(_.size)
  private val result1: Map[String, Int] = stringToTuples.mapValues(_.foldLeft(0)(_+ _._2))

//  private val result2: Map[String, Unit] = stringToInt.mapValues(println(_))

  val result3: Map[String, Int] = list.map(_.split(" ")).flatten.map((_, 1)).groupBy(_._1).mapValues(_.size)
  println(result3)
  println(result1)

}
