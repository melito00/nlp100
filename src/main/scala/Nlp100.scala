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
  }
}
