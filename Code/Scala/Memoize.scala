
class Memoize1[-T, +R](f: T => R) extends (T => R) {

  private[this] val vals = mutable.Map.empty[T, R]

  def apply(x: T): R = {
    if (vals.contains(x)) {
      vals(x)
    }
    else {
      val y = f(x)
      vals += ((x, y))
      y
    }
  }
}

def fac(n: BigInt): BigInt = {
  if (n == 0) 1
  else n*fac(n - 1)
}

val facMem = Memoize1(fac)

for (k <- 200 to 0 by -1) {
  println(facMem(k))
}