object Task4 extends App {
  val daysOfWeek = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")

  def generateWeekDayNamesUsingFoldl(daysOfWeek: List[String]): String = {
    daysOfWeek.foldLeft("") {
      (x, day) =>
        x + (if(day == daysOfWeek.head) day else ", " + day)
    }
  }

  def generateWeekDayNamesUsingFoldr(daysOfWeek: List[String]): String = {
    daysOfWeek.foldRight("") {
      (day, x) =>
        day + (if(day == daysOfWeek.last) x else ", " + x)
    }
  }

  def generateWeekDayNamesStartingWithLetterPUsingFoldl(daysOfWeek: List[String]): String = {
    daysOfWeek.foldLeft("") {
      (x, day) =>
        if(day.startsWith("P"))
          x + (if(day == daysOfWeek.head) day else ", " + day)
        else
          x
    }
  }

  println(generateWeekDayNamesUsingFoldl(daysOfWeek))
  println(generateWeekDayNamesUsingFoldr(daysOfWeek))
  println(generateWeekDayNamesStartingWithLetterPUsingFoldl(daysOfWeek))
}