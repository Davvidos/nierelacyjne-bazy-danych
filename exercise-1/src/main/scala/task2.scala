object Task2 extends App {
  def generateWeekDayNames(
        list: List[String] = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")
  ): String = list match {
    case Nil => ""
    case head :: Nil => head
    case head :: tail => head + "," + generateWeekDayNames(tail)
  }

  def generateReversedWeekDayNames(
        list: List[String] = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")
  ): String = list match {
    case Nil => ""
    case head :: Nil => head
    case head :: tail => generateReversedWeekDayNames(tail) + "," + head
  }

  println(generateWeekDayNames())
  println(generateReversedWeekDayNames())
}
