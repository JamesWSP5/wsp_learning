package basic

object demo_03 {
  /*
面向函数编程的重要理念是方法没有副作用。
好处一：计算并返回计算结果应该是方法的唯一目的，这样做的好处是降低方法之间的耦合度，因此可以更加易用和重用。
好处二：方法的参数和返回值都经过类型检测。因此可以简单的通过类型错误推断出逻辑错误，而函数式编程思想在面向对象编程中的应用也就代表对象的不可变性。
*/

  val one = List(1, 2)
  val two = List(3, 4)
  // 这里:::实现了方法的叠加
  val onetwo = one ::: two
  println(onetwo)

  //list的另外一个常用调用方法::发音为cons，作用是把新元素组合到现有列表的最前面，然后返回执行的结果的新列表。
  // 注意这里的方法调用者是函数右边的列表，通常的方法调用者为函数左边的对象，但是如果一个函数以:结尾，那么函数的调用者就为函数右边的对象。
  val three = 1 :: two
  println(three)
  //等同于一下操作
  val four = two.::(1)
  println(four)
  //Nil是空列表的简写，所以可以用cons把所有元素都串联起来，并以Nil做为结尾定义新列表。
  val join_list = 1 :: 2 :: 3 :: 4 :: Nil
  println(join_list)

  /*List类为什么没有append操作，随着列表增长，append的耗时是线性增长的，使用::作前缀仅耗费固定的时间，
   如果想用添加元素来构建列表，可以先把元素前缀进去，然后调用reverse方法。或者使用ListBuffer一种可以提供append操作的可变列表，完成之后调用to_list方法
  * */
  //  此处省略很多关于list的内置操作方法，可百度


  /*元组，是的又看见元组了，和python中的元组是一样的，元组是不可变的，但与列表不同，元组可以包含不同类型的元素。
  java如果要返回多个对个对象，就要把数据封装进一个定义好的javabean中，Scala仅支持返回元组，只需要把元组实例化所需要的对象放入括号内，并且用，号分隔开。
  元组实例化以后可以通过._或者基于1的索引进行访问元组内的元素。
  */

  val pair: (String, Int) = ("wsp", 99)
  println(pair._1)
  println(pair._2)
  //为什么不能用访问列表的方法来访问元组：因为列表的apply()方法返回的是同一类型的元素，但是元组的元素类型不一定是同一种类型。
  // _N的索引是从1开始的不是从0开始，因为对于拥有静态类型的元组的其他语言 haskell和ML从1开始是传统的规定，所以可以理解为乌龟的屁股-龟腚。

  /*set(集) 和映射（map）
  scala致力于充分利用函数式和指令风格两方面的好处，因为它的集合库区分为可变类型和不可变类型。array具有可变性，list保持不变。
  set和map来讲，Scala同样具有可变和不可变的，不过并非提供两种类型，而是通过继承的差别把可变性蕴含在其中。
   */

  var jetset = Set("hello", "hello")
  println(jetset)
  println(jetset.contains("aa"))
  //  如果要定义可变的set，就要引入Import

  import scala.collection.mutable.Set

  import scala.collection.mutable.Map

  val treasureMap = Map[Int, String]()
  treasureMap += (1 -> "hello")
  treasureMap += (2 -> ",")
  treasureMap += (3 -> "world")

  println(treasureMap(2))


  def main(args: Array[String]): Unit = {

  }

}