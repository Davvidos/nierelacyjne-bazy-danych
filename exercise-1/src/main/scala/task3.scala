import scala.annotation.tailrec

object Task3 extends App {
  val daysOfWeek: List[String] = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")

  def tailRecursivelyGenerateWeekDayNames(daysOfWeek: List[String]): String = {
    @tailrec
    def inner(daysOfWeek: List[String], day: String): String = {
      daysOfWeek match {
        case Nil => day
        case x :: tail => inner(tail, day + "," + x)
      }
    }

    inner(daysOfWeek.tail, daysOfWeek.head)
  }

  println(tailRecursivelyGenerateWeekDayNames(daysOfWeek))
}
