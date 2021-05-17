object Task5 extends App {
  def productsReducedPricesMap(): Map[String, BigDecimal] = {
    val products = Map(
      "pc" -> BigDecimal(2000.5),
      "laptop" -> BigDecimal(3500.2),
      "console" -> BigDecimal(4000.3)
    )

    products map {case (key, value) => (key, value * 0.9)}
  }

  println(productsReducedPricesMap())
}
