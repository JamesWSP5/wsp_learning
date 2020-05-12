package scala_funcation_program

object page_3 {

}

//一段有副作用的代码，cc,charge方法是一个有副作用的例子。信用卡的计费涉及与外部的交互。我们只是要一杯咖啡，但是中间牵涉信用卡的消费。
//但是中间会对测试造成困难，因为creditCard不知道该怎么去联系信用卡公司实际执行一次消费，也不知道怎么把一次计费持久到内部系统。我们可以传递一个Payments对象给buyCoffee。
class cafe {
  def buyCoffee(cc: CreditCard): Coffee = {
    val cup = new Coffee
    cc.charge(cup.price)
    cup
  }

  //  改进一字啊buyCoffee函数
  def buyCoffee_2(cc: CreditCard, p: Payments): Coffee = {
    val cup = new Coffee
    p.charge(cc, cup.price)
    cup
  }

}

class Coffee {
  var price: Int = 10
}

class CreditCard {
  var amount: Int = 10000

  def charge(money: Int): Int = {

    if (amount > money) amount -= money
    amount
  }
}

trait Payments {
  def charge(cc: CreditCard, price: Int): Unit = {
    println("我去用" + cc + "信用卡消费了" + price)
  }

}
