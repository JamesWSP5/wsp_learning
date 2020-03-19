package basic

import java.math.BigInteger

class demo_01 {

}

object demo_01 {
  //  scala对变量定义的关键字有两个，val,var，val为不可变变量，一旦初始化，后面不可再对该变量进行更改，
  //  如果要保证你的数据安全确定不会发生改变就尽可能把变量类型定义为val,类似与java中的final变量。
  val msg_1 = "你好，scala"
  //      msg = 'a'  这里我想去改变定义为val类型的一个变量就会有 reassignment to va 重新分配
  var msg_2 = 'a'
  msg_2 = 'b'
  println(msg_2) //这里会打印出结果

  var msg_3: String = "hello,scala"
  println(msg_3)

  //在定义一个方法的时候如果带有参数就要跟上参数的类型
  def max(x: Int, y: Int) = if (x > y) x else y

  // 方法也可以不带参数,返回值类型为unit，代表该函数没有有效的返回值，类似于java的void类
  def greet() = println("hell,world" + max(3, 4))

  //while循环
  def count(x: String): Int = {
    var i = 0
    while (i < x.length)
      i = i + 1
    return i
  }

  //  遍历for,foreach
  val s1 = "hello"

  private val s2: Any = s2

  val s3: Any = s3
  s1.foreach(x => println(s1))
  for (s <- s1) println(s)

  //  使用类型参数化数组（ARRAY）
  val integer: BigInteger = new BigInteger("123456")

  def main(args: Array[String]): Unit = {

    val i: Int = max(3, 4)

    println(i)
    greet()
    val count_result = count("wsp")
    println(count_result)
  }
}