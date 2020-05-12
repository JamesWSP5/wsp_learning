package day_03

import scala.io.Source

/*
  本地函数，被定义在函数内的函数，像本地变量一样，
  本地函数紧被包含它的代码块可见。
* */
object inner_functions {
  def processFile(filename: String, width: Int): Unit = {

    def processLine(filename: String, width: Int, line: String): Unit = {
      if (line.length > width)
        print(filename + ":" + line)
    }

    val source = Source.fromFile(filename)
    for (elem <- source.getLines) {
      processLine(filename, width, elem)
    }
  }

//因为是内部函数，所以函数可以直接访问外部函数的参数
  def processFile_2(filename: String, width: Int): Unit = {

    def processLine(line: String): Unit = {
      if (line.length > width)
        print(filename + ":" + line)
    }

    val source = Source.fromFile(filename)
    for (elem <- source.getLines) {
      processLine(elem)
    }
  }
}
