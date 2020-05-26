package scala_funcation_program

class page_5 {

}

//纯函数理解：A=>B的函数f，B完全由A决定，任何内部或者外部的过程的状态都不会影响到f(a)的计算结果。例如：intToString 的类型 Int=>String,它负责把整数转化为字符串。
class cafe_1 {
  def buyCoffee(cc: CreditCard): (Coffee, Charge) = {
    val cup = new Coffee()
    (cup, Charge(cc, cup.price))
  }

  def buyCoffees(cc: CreditCard, n: Int): (List[Coffee], Charge) = {
    val purchases: List[(Coffee, Charge)] = List.fill(n)(buyCoffee(cc))
    val (coffees, charges) = purchases.unzip
    (coffees, charges.reduce((c1, c2) => c1.combine(c2)))
  }
}

case class Charge(cc: CreditCard, amount: Double) {
  def combine(other: Charge) = if (cc == other.cc) Charge(cc, amount + other.amount) else throw new Exception("cant combine charges to different cards")
}

