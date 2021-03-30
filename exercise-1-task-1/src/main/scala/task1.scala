object Task1 extends App {

  def getWeekDayNames(): String = {
    val weekDays = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")
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

  def getDayNamesStartingWithLetterP(): String = {
    val weekDays = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")
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

  def getWeekDayNamesUsingWhileLoop(): String = {
    val weekDays = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")
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

  println(getWeekDayNames())
  println(getDayNamesStartingWithLetterP())
  println(getWeekDayNamesUsingWhileLoop())
}
