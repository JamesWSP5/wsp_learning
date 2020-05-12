package day_03

/*scala的函数是头等函数，不仅可以定义函数
和调用函数，还可以写成匿名的函数字面量，并把
他们称为值传递。
函数字面量被编译进类，并在运行期实例化为函数值，
因此函数字面量和值的区别在于函数字面来存在于源代码，
而函数值作为对象存在于运行期。这个区别类似于类和对象运行期的
关系
* */
object first_functions extends App {
  val a = (x: Int) => x + 1
  println(a(3))
  val someNumbers = List(-11, -10, 0, 5, 9)
  someNumbers.foreach((x: Int) => println(x + 1))

  println(someNumbers.filter((x: Int) => x > 0))

  //  函数字面量的短格式，注意利用scala的类型推断特性，可以省去参数的类型。

  println(someNumbers.filter(x => x > 0))

  // 占位符语法:可以把_当作一个或者更多参数的占位符,只要这个参数在函数字面量内只出现一次.
  // 就可以用_去代替参数
  println(someNumbers.filter(_ > 0))
  val f = (_: Int) + (_: Int)

  // _+_将扩展成两个参数的函数字面量。多个下划线代表多个参数
  println(f(1, 10))

  // 部分应用函数用一个_代替整个参数列表，例如println(_),部分函数是一种表达式，不需要提供函数所需要的参数
  // 列表
  someNumbers.foreach(println _)

}

