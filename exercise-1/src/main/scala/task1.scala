object Task1 extends App {
  def getWeekDayNames(weekDays: List[String]): String = {
    val delimiter = ","
    var result: String = ""

    for (day <- weekDays) {
      result += day

      if (day != weekDays.last) {
        result += delimiter
      }
    }

    result
  }

  def getDayNamesStartingWithLetterP(weekDays: List[String]): String = {
    val weekDaysStartingWithLetterP = for { day <- weekDays if day.startsWith("P")} yield day
    val delimiter = ","
    var result: String = ""

    for (day <- weekDaysStartingWithLetterP) {
      result += day

      if (day != weekDaysStartingWithLetterP.last) {
        result += delimiter
      }
    }

    result
  }

  def getWeekDayNamesUsingWhileLoop(weekDays: List[String]): String = {
    val delimiter = ","
    var result: String = ""
    var i = 0
    val length = weekDays.size

    while (i < length){
      result += weekDays(i)

      if (i != length - 1) {
        result += delimiter
      }

      i += 1
    }

    result
  }

  val weekDays = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")

  println(getWeekDayNames(weekDays))
  println(getDayNamesStartingWithLetterP(weekDays))
  println(getWeekDayNamesUsingWhileLoop(weekDays))
}
