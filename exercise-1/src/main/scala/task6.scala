object Task6 extends App {
  def printTriple(triple: (Boolean, Int, String)): Unit = {
    println(s"${triple._1}, ${triple._2}, ${triple._3}")
  }

  printTriple(true, 8, "Lorem ipsum dolor sit amet")
}
