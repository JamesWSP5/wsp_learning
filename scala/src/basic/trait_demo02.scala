package basic

object trait_demo02 extends App {
  val oracleDB = new OracleDB with Operate3
  oracleDB.insert(100)

  val mysqlDB = new MySql3  with  Operate3 {
    override def say(): Unit = {
    println("这是mysql的连接")
    }
  }
  mysqlDB.insert(1000)
  mysqlDB.say()
}

trait Operate3 {
  def insert(id: Int) = {
    println(("插入数据是" + id))
  }
}

class OracleDB {

}

abstract class MySql3 {
  def say()
}