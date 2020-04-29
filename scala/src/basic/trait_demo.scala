package basic

/*java中的接口：
1）java中，一个类可以实现多个接口
2）java中，接口之间支持多继承
3）接口中属性都是常量
4）接口中方法都是抽象的
scala中接口：
1）从面向对象来看，接口在java中并不是面向对象的范畴，scala是纯面向对象的语言。
2）当多个类具有相同的特征就可以把这个特征独立出来，采用关键字trait来声明。trait等价于
（interface+abstract class）
3）scala的trait除了有直接继承以外还有动态混入。更加灵活。
4）在scala中，java中的接口可以当特质使用
继承特质：
有父类：
class 类名 extends 特质1 with 特质2 with 特质3.。。。
无父类：
class 类名 extends 父类 with 特质1 with 特质2
如果有父类的话父类要放在前面。


带有特质的对象，动态混入。
1）除了可以在类声明时继承特质外，还可以在构建对象时混入特质，扩展目标类的功能。
2）此种方式也可以应用与对抽象类功能进行扩展。
3）动态混入是scala特有的方式，在不修改类和定义的情况下，扩展类的功能。
4）动态混入可以在不影响原有的继承关系的基础上，给指定的类扩展功能。
* */


//特质可以同时拥有抽象方法和具体方法，一个类可以实现/继承多个特质。
object trait_demo extends App {
  private val sheep = new Sheep
  sheep.sayHi
  sheep.sayHello
}

trait Trait03 {
  // 定义一个抽象方法
  def sayHi

  //实现普通方法
  def sayHello = {
    println("say Hello")
  }
}

class Sheep extends Trait03 {
  override def sayHi(): Unit = {
    println("say hi")
  }
}

