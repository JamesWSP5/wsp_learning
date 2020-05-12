package scala_funcation_program

//引用透明，纯粹性和代换模型理解
//引用透明：函数无论进行了任何操作都可以用它的返回值来代替。这种限制使得推导一个程序的求值变的简单自然。
//如果表达式是引用透明的，可以想象计算过程就像在解代数方程。展开表达式的每一部分，使用指示对象代替变量，然后规约到最简单的形式。
//在这一过程中每一项都被等价值所替代，计算的过程被一个又一个的等价值所替代。引用透明是的程序具备了等式推理的能力。
object page_08 extends App {
  val x = "Hello,World"
  val r1 = x.reverse
  val r2 = x.reverse
  // 假如我们把所有使用x的地方使用"Hello,World"来替代，结果是一样的。
  //  val r1 = "Hello,World".reverse
  //  val r2 = "Hello,World".reverse
  //r1和r2也是引用透明的，也可以在引用他们的程序中等值替代而不会对结果产生影响。

  //  下面是一个非引用透明的例子.

  val y = new StringBuilder("Hello")
  val z = y.append(",world")
  val r3 = z.toString()
  val r4 = z.toString()

  //  我们再用刚才的方法来调用，r5和r6不再相等，看到这里我们知道StringBuilder.append不是一个纯函数。虽然r5,r6看起来像是一样的表达式。
  //  在r6调用append的时候已经改变了a的引用对象。
  val a = new StringBuilder("Hello")
  val r5 = a.append(", World").toString()
  println(r5)
  val r6 = a.append(", World").toString()
  println(r6)

}
