package basic



/*学习函数式编程风格和指令式编码风格的区别，鼓励使用函数式编码风格。
  然后就看了一大堆资料，我理解的指令式编码和函数式编码的区别，如果代码包含了任何var的变量，程序就是指令式的编码风格。
  如果代码仅有var定义的变量，那就是函数式编程。
  https://www.jianshu.com/p/eebb15f2c0d5这个讲的不错可以看一下。
 */


object demo_04 {

  // 下面可以看一下两个风格的代码

  //  指令式方法
  def print_string_01(input: String) = {
    var i = 0
    while (i < input.length) {
      println(input(i))
      i += 1
    }
  }

  /*
    def print_string_02(input: Array[String]) = {
      for (str <- input) println(str)
    }
  */

  //函数式方法
  def print_string_03(input: String): Any = {
    for (str <- input) println(str)
  }

  //这个函数式编码方式看起来更简单
  def print_string_04(input: String): Any = {
    input.foreach(println)
  }

  //  scala程序员的平衡感，崇尚val，不可变对象和没有副作用的方法。
  //  只有在特定需要和加以权衡之后才选择var,可变对象和有副作用的方法。
  def main(args: Array[String]): Unit = {
    print_string_01("hello")
    //    print_string_02(Array("hello", "woeld"))
    print_string_03("hell0")
    print_string_04("hello")
  }
}
