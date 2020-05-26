package day_03

import scala.annotation.tailrec

/*
写一个尾递归斐波那契的尾递归函数。
*/
object scala_function extends App {

  def fib(n: Int): Int =
    if (n == 0) {
      0
    }
    else if (n == 1) {
      1
    }
    else {
      fib(n - 1) + fib(n - 2)
    }

  var n = fib(3)
  println(n)


  //实现isSorted方法，检测Array[A]是否按照给定的比较函数排序。
  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    @annotation.tailrec
    def loop(n: Int, res: Boolean): Boolean =
      if (n >= 0) res
      else loop(n - 1, res && ordered(as(n), as(n - 1)))

    loop(as.length, true)
  }

  //  高阶函数
  def partiall[A, B, C](a: A, f: (A, B) => C): B => C = (b: B) => f(a, b)

  //  柯里化
  def curry[A, B, C](f: (A, B) => C): A => (B => C) = a => { b => f(a, b) }

  def curriedSum(x: Int)(y: Int) = x + y

  val intToInt: Int => Int = curriedSum(1)
  println(intToInt(2))

  //  反柯里化
  def uncurry[A, B, C](f: A => B => C): (A, B) => C = (a, b) => f(a)(b)

  //  实现一个高阶函数，可以组合两个函数为一个函数
  def compose[A, B, C](f: B => C, g: A => B): A => C = a => f(g(a))


  //  val x = List(1, 2, 3, 4, 5) match {
  //    case Cons(x, Cons(2, Cons(4, _))) => x
  //  }
  //  println(x)

  List("a", "b")
  var l = Cons("a", Cons("b", Nil))
  println(l)
}

sealed trait List[+A]

case object Nil extends List[Nothing]

case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }


  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

}