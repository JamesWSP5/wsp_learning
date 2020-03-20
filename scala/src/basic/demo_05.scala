package basic

import scala.io.Source

class demo_05 {
  //在这里可以放类的方法和变量，这些被称为类的成员。
  //  var sum = 0
  private var sum = 0

  //  def add(b: Byte) = sum += b
  def add(b: Byte) = {
    //    b = 1 编译不通过
    //   scala中方法参数的一个重要特征是都是val类型的。
    sum += b
  }

  def checksum(): Int = return ~(sum & 0XFF) + 1
}

/*1.scala的io
* 2.scala的类和对象
* */
object demo_05 {
  def read_text(file_name: String) =
    for (line <- Source.fromFile(file_name).getLines)
      println(line)

  def main(args: Array[String]): Unit = {
    read_text("src/basic/demo_05.scala")
    //acc的对象是val不可变的，但是可以修改acc指向的对象，val对acc的限制是不能再赋值为其他对象
    val acc = new demo_05
    val csa = new demo_05
    acc.sum = 3
    println("acc.sum是: " + acc.sum + "\n" + "csa.sum是: " + csa.sum)
  }


}