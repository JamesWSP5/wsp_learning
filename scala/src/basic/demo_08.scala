package basic

import java.io.File

/*内建控制结构*/
object demo_08 {

  def main(args: Array[String]): Unit = {
    //if 表达式
    var file_name = "default.txt"
    if (file_name.length > 3)
      file_name = "i am more than three"
    println(file_name)
    //但是可以使用val
    val file_name_one = if ("abcd".length > 4) "a" else "b"
    println(file_name_one)

    // while循环 求两个数的最大公约数

    def gcdLoop(x: Long, y: Long) = {
      var a = x
      var b = y
      while (a != 0) {
        val temp = a
        a = b % a
        b = temp
      }
      b
    }

    //    println(gcdLoop(9, 4))

    //  for 枚举聚合类
    //  每次枚举，file的新的val就被元素值初始化，编译器能够推断出file的类型是File。
    //    scala提供的这种遍历方式能够避免出现超位溢出的问题。
    val files: Array[File] = new File(".").listFiles()
    for (file <- files)
      println(file)

    //   to和untile 在range类型中去区别
    //   to 包含上边界，until不包含上边界。
    for (i <- 1 to 4)
      println(i)

    for (i <- 1 until 4)
      println(i)
    //如果你并不想要全部的输出结果。可以对结果进行遍历。
    for (file <- files if file.getName.endsWith("src"))
      println(file)

    // 嵌套枚举
    // 制造新集合和yield关键字
    val files1: Array[File] = for {file <- files if file.getName.endsWith("src")
                                   }
      yield file
    for (file <- files1)
      println(file)

    // try的异常处理 try catch finally

  }
}
