object Task3 extends App {
  case class Osoba(imie: String, Nazwisko: String)

  def greetPerson(person: Osoba): String = person match {
    case Osoba("Ignacy", "Lewicki") => "Witam szanownego Pana Ignacego."
    case Osoba("Tytus", "Kosiński") => "Hej, co tam u Ciebie słychać?"
    case Osoba(imie, nazwisko) => s"Witaj ${imie} ${nazwisko}, serdeczne pozdrowienia!"
  }

  var osoba1 = Osoba("Ignacy", "Lewicki");
  println(greetPerson(osoba1))

  var osoba2 = Osoba("Tytus", "Kosiński");
  println(greetPerson(osoba2))

  var osoba3 = Osoba("Dawid", "Jurczyński");
  println(greetPerson(osoba3))
}
