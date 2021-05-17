object Task4 extends App {
  def functionAsArgument(value: Int, x: Int => Int): Int = {
    x(x(x(value)))
  }

  println(functionAsArgument(2, (x: Int) => x * 2))
}