package day_03

import scala.io.StdIn

/*
case_class是避免在对象上使用模式匹配时需要大量的固定写法而采用的方式。
通常你要知道只是在哪些你希望用来做模式匹配的每个类前加case关键字。*/
object case_class extends App {
  val v = Var("x")
  println(v.name)
  // 第二个语法便捷的设定是样本类参数列表中的所有参数隐式的获得了val的前缀
  val op = BinOp("+", Number(1.0), v)
  println(op.left)
  //第三个，编译器为你的类添加了toString,hashCode和equals的自然实现。
  println(op.hashCode())
  // 样本类最大的好处是支持了模式匹配，但是会增大类和对象的内存。

  //  模式匹配。
  Unop("-", Unop("-", v))

  //类似于"+"或1这样的常量模式匹配的值等于用==判断相等的常量
  // match和switch的比较：1.始终一值作为结果，2.scala的备选项表达式永远不会掉到下一个case.3.如果没有
  // 模式匹配，MatchError异常会被抛出。
  "c" match {
    case "a" => println("这是a")
    case "b" => println("这是b")
    case _ =>
  }

  def describe(x: Any) = x match {
    case 5 => "five"
    case true => "truth"
    case "hello" => "hi!"
    case Nil => "empty"
    case _ =>
  }

  println(describe(5))
  println(describe(true))
  println(describe(Nil))
  // 变量模式，变量模式类似于通配符可以匹配任意对象。不过与通配符不同的地方在于，scala把变量绑定在匹配的对象上
  //  因此之后你可以使用这个变量操作对象。
  var expr: Any = 0
  expr match {
    case 0 => "zero"
    case "a" => "a"
  }
  // 构造器模式，使得匹配模式真正变得强大。scala支持深度匹配。
  expr match {
    case BinOp("+", e, Number(0)) => println("a deep match")
    case _ =>
  }
  // 序列模式
  val s = List(0, 1, 2)

  def x(a: Any) = a match {
    case List(0, _, _) => println("ff")
    case _ =>
  }

  println(x(s))

  // 嬾加載模式 关键字Lazy使用，可以修饰变量和函数，在函数或者遍历使用的时候才会初始化
  //修饰的关键字必须是val，必须是线程安全的。
  lazy val lazy_variable = 11
  println(lazy_variable)

  def say_hello: Unit = {
    lazy val res = sum(1, 10)
    println("----------------")
    println("res是" + res) //这里注释掉调用的这行函数，sum函数就不会被真正的调用。
  }

  say_hello

  def sum(n1: Int, n2: Int): Int = {
    println("sum()执行了")
    return n1 + n2
  }

  //scala的异常处理,try,catch,finally
  try {
    val r = 10 / 0
  } catch {
    case ex: ArithmeticException => {
      println("捕获除数为0的异常")
    }
    case ex: Exception => {
      println("捕获了异常")
    }
  } finally {
    println("无论有没有异常都要处理")
  }
  println("请输入1-9之间的一个数字")
  val n = StdIn.readInt()
  println(n)
  for (i <- 1 to n) {
    for (j <- 1 to i) {
      printf("%d *%d = %d\t", j, i, j * i)
    }
    println()
  }

  val map = Map("A" -> 1, "B" -> 0, "C" -> 3)
  for ((k, v) <- map) {
    println(k + "->" + v)
  }
  for ((k, 0) <- map) {
    println(k + "->" + 0)
  }

  for((k,v)<-map if v>=1){
    println(k + "->" + 0)
  }

  val (x,y,z)=(1,2,"hello")
  println("x="+x)
  val (q,r)=BigInt(10)/%3
  val arr = Array(1,7,2,9)
  val Array(first,second,_*)=arr
  println(first,second)


}

abstract class Expr

case class Var(name: String) extends Expr

case class Number(num: Double) extends Expr

case class Unop(opetator: String, arg: Expr) extends Expr

case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

//使用case修饰类会自动给类加上一些便捷设定，会添加于类名一致的工厂方法。
class Person(inName: String, inAge: Int) {
  var name: String = inName
  var age: Int = inAge
  age += 10
  override def toString = {
    "name" + this.name + "\t age" + this.age
  }
  println("age" + age)
}
