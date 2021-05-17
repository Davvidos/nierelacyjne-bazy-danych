abstract class Osoba(val imie: String, val nazwisko: String) {
  def podatek(): BigDecimal

  override def toString = s"imię: $imie, nazwisko: $nazwisko, podatek: $podatek"
}

trait Student extends Osoba {
  override def podatek(): BigDecimal = 0
}

trait Pracownik extends Osoba {
  private var _pensja: BigDecimal = 0

  override def podatek(): BigDecimal = 0.2 * pensja

  def pensja: BigDecimal = _pensja

  def pensja_= (value: BigDecimal): Unit = _pensja = value
}

trait Nauczyciel extends Pracownik {
  override def podatek(): BigDecimal = 0.1 * pensja
}

object Task5 extends App {
  val student = new Osoba("Dawid", "Jurczyński") with Student
  println(s"Student - $student")

  val pracownik = new Osoba("Ignacy", "Lewicki") with Pracownik
  pracownik.pensja = 2500
  println(s"Pracownik - $pracownik")

  val nauczyciel = new Osoba("Tytus", "Kosiński") with Nauczyciel
  nauczyciel.pensja = 2500
  println(s"Nauczyciel - $nauczyciel")

  val studentPracownik = new Osoba("Marcin", "Kwaśniewski") with Student with Pracownik
  studentPracownik.pensja = 2500
  println(s"Student a potem Pracownik - $studentPracownik")

  val pracownikStudent = new Osoba("Łukasz", "Zielony") with Pracownik with Student
  pracownikStudent.pensja = 2500
  println(s"Pracownik a potem Student - $pracownikStudent")
}
