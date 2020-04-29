package basic

//创建一个抽象类
abstract class Element {
  def contents: Array[String]
  //定义无参数方法
  def height: Int = contents.length
  val height_val: Int = contents.length

  def width: Int = if (height == 0) 0 else contents(0).length
  val width_val: Int = if (height == 0) 0 else contents(0).length




//统一访问原则，如果方法中没有参数就可以去掉括号，这样方法的调用和变量的调用是一致的。
//看起来功能式一样多的，但是差别就在与访问访问字段的速度比调用方法的略快，因为字段在类初始化的
// 时候被预计算，而方法每次调用都要被计算。使用字段要为每个Element对象分配更多内存空间（因为字段
//在类初始化的时候都要被预计算）。各有各的
//优点，时间和空间取最优解才是好的选择，
//还有在别的程序用到的时候不会因为这个改变而受影响.
}

object Element extends  App {
  val el_1 = new Element {
    override def contents: Array[String] = Array("a", "b")
  }
  println(el_1.height)
  println(el_1.width)

}
//扩展的类继承了父类的所有非私有成员（字段和方法）
//继承标识超类所有的成员是子类的成员，
class ArrayElement(conts:Array[String]) extends Element{
  override def contents: Array[String] =conts



}




