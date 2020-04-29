package basic

import scala.annotation.meta.{getter, setter}
import scala.collection.{immutable, mutable}


class demo_11 {

  private[this] var _age: Int = 10
  private[this] var _name: String = "小花"

  @getter
  def age: Int = _age

  @setter
  def age_=(value: Int): Unit = {
    _age = value
  }
  @getter
  def name: String = _name
  @setter
  def name_=(value: String): Unit = {
    _name = value
  }


}

object a{
  def main(args: Array[String]): Unit = {
    val demo_11 = new demo_11
    println(demo_11.name)
    println(demo_11.age)

  }
}


object demo_11 {
  val demo_11 = new demo_11
  println(demo_11.age)
  demo_11.age=101

  println(demo_11.age)

  def main(args: Array[String]): Unit = {
    val mu_map = mutable.HashMap[String, String]()
    val im_map = immutable.HashMap[String, String]()

    //  mu_map += ("1" -> "scala")
    //  mu_map.mkString("、")
    //  im_map += ("1" -> "scala")

    val l1 = List(1, 2)
    println(l1(0))

    var set = Set(1, 2, 3, 4, 5, 6, 7)

    set += 9
    println(set)
  }

}