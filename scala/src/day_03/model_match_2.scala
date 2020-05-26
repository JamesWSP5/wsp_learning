package day_03

import java.io.File

object model_match_2 extends App {
  private val files: Array[File] = new File(".").listFiles()
  println(files.mkString)

  //  这是一个高阶函数
  private def filesMatching(matcher: String => Boolean) =
    for (file <- files; if matcher(file.getName))
      yield file

  def filesEnding(query: String) =
    filesMatching(_.endsWith(query))

  def filesContains(query: String) =
    filesMatching(_.contains(query))

  def filesRegex(query: String) =
    filesMatching(_.matches(query))

  private val files1: Array[File] = filesEnding("md")
  println(files1.mkString)
}
