package mobi.jnkymd.nlp100

import java.nio.file.Files
import java.nio.file.Paths
import java.util.stream.Stream
import java.util.function._
import java.nio.charset.StandardCharsets
import java.io.IOException

class p00

object p00 {
  def ReverseString(s: String): String = {
    if (s.length == 1) s
    else ReverseString(s.substring(1)) + s.charAt(0)
  }

  def OddString(s: String): String = {
    s.zipWithIndex.filter({ case (c: Char, i: Int) => i % 2 != 0}).map(x => x._1).mkString
  }

  def MergeString(s1: String, s2: String): String = {
    def mergeList[A](l1: List[A], l2: List[A]): List[A] = {
      (l1, l2) match {
        case (_ , Nil) => l1
        case (Nil, _) => l2
        case (x::xRest, y::yRest) => x::y::mergeList(xRest, yRest)
      }
    }
    mergeList(s1.toList, s2.toList).mkString
  }
  def CountChars(s: String): List[Int] = {
    // "Now I need a drink, alcoholic of course, after the heavy lectures involving quantum mechanics."
    s.split(" ").map(s => s.collect { case x: Char if x.isLetter => x}.length).toList
  }
  def p04(): Unit = {
    val s = "Hi He Lied Because Boron Could Not Oxidize Fluorine. New Nations Might Also Sign Peace Security Clause. Arthur King Can."
    val indexies = Array(1, 5, 6, 7, 8, 9, 15, 16, 19)

    println(s.split(" ").zipWithIndex.collect {
      case (s, i) if indexies.exists(_ == i + 1) => (s.charAt(0), i +1)
      case (s, i) => (s.substring(0, 2), i + 1)
    }.toMap)
  }
  def NGram(stream: String): List[String] = {
    stream.split(" ").toList

  }

  def NGram(stream: List[String]): List[String] = {
    stream
  }
}

object Nlp100 {
  def main(args: Array[String]): Unit = {
    val file = "file.txt"
    try {
      val stream = Files.lines(Paths.get(file), StandardCharsets.UTF_8)
      stream.forEach(new Consumer[String] {
        override def accept(t: String): Unit = println(t)
      })
    } catch {
      case e: IOException => e.printStackTrace()
    }
    println(p00.ReverseString("stressed"))
    println(p00.CountChars("Now I need a drink, alcoholic of course, after the heavy lectures involving quantum mechanics."))
    p00.p04()
  }
}
