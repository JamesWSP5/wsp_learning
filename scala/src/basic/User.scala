package basic
import scala.App
import scala.annotation.meta.{getter, setter}

class User(private var _x: Int, private var _y: Int,c:Int=3) {

  @getter
  def x: Int = _x

  @setter
  def x_=(value: Int): Unit = _x = value


  @getter
  def y: Int = _y

  @setter
  def y_=(value: Int): Unit = _y = value
  println(c)
}

object other {
  val user = new User(0, 0)
  println(user.y)
}

object User {
  def main(args: Array[String]): Unit = {
    val user1 = new User(0, 0)
    println(user1.x)
    println(user1.y)


  }
}

object user1 extends App {
  private val user = new User(1,2)
  println(user)
}

//如果类里面既没有方法，也没有变量可以省略｛｝
//生成伴生对象，新建一个该类的对象，需要走默认的构造参数，当然也可以重构构造参数。

