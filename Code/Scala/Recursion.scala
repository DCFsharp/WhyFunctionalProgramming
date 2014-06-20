// Recursion in Scala
// (1) yields a "java.lang.StackOverflowError" with large lists
def sum(ints: List[Int]): Int = ints match {
  case Nil => 0
  case x :: tail => x + sum(tail)
}

// (2) tail-recursive solution
def sum2(ints: List[Int]): Int = {
  @tailrec
  def sumAccumulator(ints: List[Int], accum: Int): Int = {
    ints match {
      case Nil => accum
      case x :: tail => sumAccumulator(tail, accum + x)
    }
  }
  sumAccumulator(ints, 0)
}


object Fibonacci extends App {

  println(fib(1, 2))

  def fib(prevPrev: Int, prev: Int) {
    val next = prevPrev + prev
    println(next)
    if (next > 1000000) System.exit(0)
    fib(prev, next)
  }



  def fib: Stream[Long] = {
    def tail(h: Long, n: Long): Stream[Long] =
      h #:: tail(n, h + n)
    tail(0, 1)
  }

  object Factorial extends App {

    // tail-recursive factorial method
    def factorial2(n: Long): Long = {
      @tailrec
      def factorialAccumulator(acc: Long, n: Long): Long = {
        if (n == 0) acc
        else factorialAccumulator(n*acc, n-1)
      }
      factorialAccumulator(1, n)
    }
  };

