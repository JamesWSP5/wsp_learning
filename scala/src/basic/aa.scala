package basic

object PersonInfo {
  def main(args: Array[String]) {
    val p = Person("Jonathan")
    p.name = "Jony" // setter method
    println(p.name) // getter method
    println(Person("gg")) //toString()方法
    println(new Person()) //toString()方法
  }
}

object StudentInfo {
  def main(args: Array[String]): Unit = {
    val student = new Student()
    student.age=30
    println(student.content)
  }
}

case class Person(private var _name: String) {
  def this() = this("Tom") //构造方法，添加默认值
  def name = _name // accessor访问
  def name_=(aName: String) {
    _name = aName
  } // mutator---->突变
  override def toString() = s" teacher name : $name"
}


//有参构造方法
class Student {
  var age:Int = _
  var score:Int = _
  var content:Int = _

  //  def this(age: Int, score: Int) {
  //    this()
  //    this.age = age
  //    this.score = score
  //  }

}