object Task7 extends App {
  def getProductsValues(key: String): Option[BigDecimal] = {
    val products = Map(
      "pc" -> BigDecimal(2000.5),
      "laptop" -> BigDecimal(3500.2),
      "console" -> BigDecimal(4000.3)
    )

    products.get(key)
  }

  println(getProductsValues("nintendo").getOrElse(0))
  println(getProductsValues("pc").getOrElse(0))
}
