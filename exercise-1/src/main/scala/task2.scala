object Task2 extends App {
  def generateWeekDayNames(list: List[String]): String = list match {
    case Nil => ""
    case head :: Nil => head
    case head :: tail => head + "," + generateWeekDayNames(tail)
  }

  def generateReversedWeekDayNames(list: List[String]): String = list match {
    case Nil => ""
    case head :: Nil => head
    case head :: tail => generateReversedWeekDayNames(tail) + "," + head
  }

  val weekDays = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")

  println(generateWeekDayNames(weekDays))
  println(generateReversedWeekDayNames(weekDays))
}
