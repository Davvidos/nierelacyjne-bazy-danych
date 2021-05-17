object Task8 extends App {
  def removeZeros(list: List[Int]): List[Int] =  list match {
    case Nil => List()
    case 0 :: tail => removeZeros(tail)
    case head :: tail => List(head) ++ removeZeros(tail)
  }

  val numbers = List(0, 7, -1, 4, -9, 0, 8, 2, -7, 0)
  println(removeZeros(numbers))
}
