package basic

/*scala比java更具有面向对象一点是scala不可以定义静态成员，而是代以定义的单例对象
* 除了obbject关键字代替了class以外，单例对象看上去和类的定义是一样的。
* */
class demo_06 {

}
/*当单例对象和某个类共享一个名字的时候，它就是这个类的伴生对象，类和他的半生对象必须定义在一个源文件中。
* 类被称为这个单例对象的伴生类，类和伴生对象可以相互访问其私有变量。
* */
object demo_06{

  def main(args: Array[String]): Unit = {

  }
}