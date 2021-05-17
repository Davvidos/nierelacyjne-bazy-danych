object Task4 extends App {
  val daysOfWeek = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")

  def generateWeekDayNamesUsingFoldLeft(daysOfWeek: List[String]): String = {
    daysOfWeek.foldLeft("") {
      (x, day) =>
        x + (if(day == daysOfWeek.head) day else ", " + day)
    }
  }

  def generateWeekDayNamesUsingFoldRight(daysOfWeek: List[String]): String = {
    daysOfWeek.foldRight("") {
      (day, x) =>
        day + (if(day == daysOfWeek.last) x else ", " + x)
    }
  }

  def generateWeekDayNamesStartingWith_P_LetterUsingFoldLeft(daysOfWeek: List[String]): String = {
    daysOfWeek.foldLeft("") {
      (x, day) =>
        if(day.startsWith("P"))
          x + (if(day == daysOfWeek.head) day else ", " + day)
        else
          x
    }
  }

  println(generateWeekDayNamesUsingFoldLeft(daysOfWeek))
  println(generateWeekDayNamesUsingFoldRight(daysOfWeek))
  println(generateWeekDayNamesStartingWith_P_LetterUsingFoldLeft(daysOfWeek))
}
