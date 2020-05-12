package day_03

import java.io.File
//高阶函数
//所有的函数都可以被分成通用部分（它们在每次函数调用中都相同），以及非通用部分（在不同的函数调用种可能会变化）。
//通用部分是函数体，非通用部分必须由参数提供。当你把函数值用作参数时，算法的非通用 部分就是它代表的某些其他算法
//在这种函数的每一次调用中，你都可以把不同的函数值作为参数传入。被调用函数将每次选用参数时候调用传入的函数值。

object model_match extends App {
  private val listFiles: Array[File] = new File(".").listFiles

  println(listFiles.mkString)

  def filesEnding(query: String) =
    for (file <- listFiles; if file.getName.endsWith(query))
      yield file

  def filesContaining(query: String) =
    for (file <- listFiles; if file.getName.contains(query))
      yield file


  def filesRegex(query: String) =
    for (file <- listFiles; if file.getName.matches(query))
      yield file

  def filesMatching(query:String,matcher:(String,String)=>Boolean)={
    for (file <- listFiles; if file.getName.matches(query))
      yield file
  }



}
