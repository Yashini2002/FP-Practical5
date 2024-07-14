object Fibonacci {

  def main(args: Array[String]): Unit = {
    val n = 10 
    println(s"First $n Fibonacci numbers:")
    printFibonacci(n)
  }

  def printFibonacci(n: Int): Unit = {
    if (n <= 0) {
      println("Please enter a positive integer.")
    } else {
      for (i <- 0 until n) {
        print(s"${fibonacci(i)} ")       }
      println() 
    }
  }

  def fibonacci(n: Int): Int = {
    n match {
      case 0 => 0
      case 1 => 1
      case _ => fibonacci(n - 1) + fibonacci(n - 2)
    }
  }
}
