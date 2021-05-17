class KontoBankowe(stanKontaPoczatkowy: BigDecimal) {
  private var _stanKonta: BigDecimal = stanKontaPoczatkowy

  def this() = this(0)
  def stanKonta: BigDecimal = _stanKonta

  def wplata(kwota: BigDecimal): Unit = {
    this._stanKonta = this._stanKonta + kwota
  }

  def wyplata(kwota: BigDecimal): Unit = {
    this._stanKonta = this._stanKonta - kwota
  }
}

object Task2 extends App {
  def runOperation(): Unit = {
    val account = new KontoBankowe(3500)
    account.wplata(800)
    account.wyplata(300)
    println(account.stanKonta)
  }

  runOperation()
}
