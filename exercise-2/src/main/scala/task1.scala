object Task1 extends App {
  def checkDay(day: String): String = day match {
    case "Poniedziałek" | "Wtorek" | "Środa" | "Czwartek" | "Piątek" => "Praca"
    case "Sobota" | "Niedziela" => "Weekend"
    case _ => "Nie ma takiego dnia"
  }

  println(checkDay("Poniedziałek"))
  println(checkDay("Wtorek"))
  println(checkDay("Środa"))
  println(checkDay("Czwartek"))
  println(checkDay("Piątek"))
  println(checkDay("Sobota"))
  println(checkDay("Niedziela"))
  println(checkDay("Inny_kosmiczny_dzień"))
}
