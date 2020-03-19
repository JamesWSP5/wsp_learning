package basic

import java.math.BigInteger

class demo_02 {

}

/*
  scala中使用new实例化对象，实例化过程中。实例化的过程中可以用值或者类型使对象参数化（parameterize）,
  通俗点讲就是在新建对象的时候穿进去一个值，或者类型对象完成新对象的初始化。

 */

object demo_02 {

  //传入值初始化对象
  val biginter = "123456789"
  val bigInteger = new BigInteger(biginter)
  //传入类型参数实例化对象,使用类型实例化对象，首先写[]类型参数，然后写()值参数
  val array: Array[String] = new Array[String](3)
  array(0) = "hello"
  array(1) = ","
  array(2) = "world"
  //注意此处我们定义的是一个val类型的数组类型变量，
  //但是我们可以通过括号和索引的方式对该变量进行赋值操作，这里val定义对象这个对象就不可以被改变，但是这个对象内部是可以改变的。
  //这个例子val指向的始终是Array[String]实例。
  for (i <- 0 to 2)
    println(array(i))

  //  scala里面的所有的操作符都是方法调用,没有操作符重载，1+2的操作是1.+（2），0 to 2 实际操作是0.to(2)
  //  scala为什么要用()访问数组，即取值，用（）传递给参数一个或者多个值参数的时候，实际上调用的是apply()方法。这个原则不仅仅是只应用于数组，对于
  //  任何对象的值参数应用都将转化为apply方法的应用。
  //  与之相似，当对带有括号包括一到若干个参数赋值时都会调用对象的update方法对括号里面的参数和等号右边的对象进行执行调用。
  array(0) = "give me a value"
  //  相当于执行array.update(0,"give me a value")

  //  所以上面的操作可以等价于进行了以下操作

  val array1: Array[String] = new Array[String](3)
  array1.update(0, "hello")
  array1.update(1, ",")
  array1.update(2, "world")
  for (i <- 0 to 2)
    println(array1.apply(i))


  val numNames = Array("zero", "one", "two")

  //FallbackArrayBuilding调用了创造并返回新数组的apply工厂方法。apply方法可以有不定个数的参数，定义在array的伴生对象（companion object 中）可以点击array进去观看
  //  完整写法可以如下
  val numNames2 = Array.apply("zero", "one", "two")


  def main(args: Array[String]): Unit = {

  }
}
