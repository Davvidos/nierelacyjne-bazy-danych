object Task9 extends App {
  def addOneToNumber(list: List[Int]): List[Int] = {
    list map {
      case (element) => element + 1
    }
  }

  val numbers = List(0, 7, -1, 4, -9, 0, 8, 2, -7, 0)
  println(addOneToNumber(numbers))
}
