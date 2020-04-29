package basic

import scala.io.{BufferedSource, Source}


//第八章
//方法 定义函数最通用的方法是做为某个对象的成员。这种函数称为方法。

object demo_09 {


  private def processLine(filename: String, width: Int, line: String) = {
    if ((line.length > width))
      println(filename + ":" + line.trim)
  }

  def processFile(filename: String, width: Int): Unit = {
    val source: BufferedSource = Source.fromFile(filename)
    for (line <- source.getLines()) {
      processLine(filename, width, line)
    }
  }


  def main(args: Array[String]): Unit = {
    //    processFile(".", 10)


    // scala的函数是头等函数，可以定义和调用函数，，还可以把他们写成匿名的字面量，并把他们作为指传递。
    //  函数字面量被编译进类，并在运行期实例化为函数值。因此函数字面量和值的区别在于函数字面量存在与源代码中。
    var increase = (x: Int) => x + 1
    println(increase(11))

    // 函数字面量的短格式
    //scala提供了很多方法去除冗余的信息，可以把代码写的更简短，比如参数的类型推断。
    /*someNumbers.filter((x)=>x>0)
    * 这里没有写入x的参数类型，编译器也会知道X一定是整数，因为我们去过滤了一个整数的集合
    * */
    //  神奇的占位符，在代码中加入占位符去代替一个或者多个参数的位置。
    //  someNumbers.filter(_>0) 可以把下划线看作表达式里需要被填入的空白。
    val someNumbers = List(1, 2, 3, 4, -5)
    val someNumbers_filter: List[Int] = someNumbers.filter(_ > 0)
    println(someNumbers_filter)
    //   有时候写占位符，编译器不能推断出参数的类型，需要自己手动加上参数的类型
    val add = (_: Int) + (_: Int)
    println(add(5, 5))
    //  _占位符代替整个参数列表，在使用——去代替一个参数或者整个参数列表的时候要在函数名和下划线之间
    //  留一个空格，不这样做编译器会认为你再说明一个不同的符号
    someNumbers.foreach(println _) //==>somNubers.foreach(x=>println(x))

    def sum(a: Int, b: Int, c: Int) = a + b + c

    val i: Int = sum(1, 2, 3)
    println(i)
    val a = sum _
    println(a(2, 3, 4))
    // 实际上是名为a的变量指向了一个函数值对象。这个函数值是有scala依照函数sum _自动产生的一个实例。
    //    编译器产生的类有一个apply方法带了3个参数。

    //减少代码重复，所有的函数都可以被分成通用部分，以及非通用部分。通用部分是函数体
    // 非通用部分必须由参数提供。






  }
}
