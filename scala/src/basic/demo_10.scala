package basic

class demo_10 {

}

object demo_10 {
  def main(args: Array[String]): Unit = {
    new father{}.introduce
    new son {}.introduce
  }
}

abstract class father {
  private val age = 80
  val money = 9000000

  def introduce = println("我是爸爸，我的年龄是" + age + "我还有" + money)
}

abstract class son extends father {
  private val age = 20
  override val money: Int = 30
  override def introduce = println("我是儿子，我的年龄是" + age + "我还有" + money)
}