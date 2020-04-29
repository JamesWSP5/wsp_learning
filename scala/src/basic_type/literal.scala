package basic_type

//字面量即使直接写在代码里的常量值
//scala中的基本数据类型和java中的基本数据类型不同，scala中是一门真正意义上的面向对象的语言
//包括基本数据类型也是一个个的对象，所以当我们在新建一个字面对象的时候可以去调用它的方法看一下。
object literal extends App {
  val i = 10
  var str_1: String = i.toString
  println(str_1)
}

