object Task10 extends App {
  def getBothLists(): Unit = {
    val numbers = List(0, 7, -1, 4, -9, 0, 8, 2, -7, 0, 15, 25.5, -50.5, 58, 2.5, -3.75, -10, 5.75)
    println(numbers)

    val filteredList = mapToAbsoluteValuesInRange(numbers)
    println(filteredList)
  }

  def mapToAbsoluteValuesInRange(list: List[Double]): List[Double] = {
    list
      .filter(elem => elem >= -5)
      .filter(elem => elem <= 12)
      .map(elem => elem.abs)
  }

  getBothLists()
}
