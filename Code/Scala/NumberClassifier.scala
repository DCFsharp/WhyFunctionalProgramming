object NumberClassifierFunctional {

  def isFactor(number: Int, factor: Int) =
    number % factor == 0

  def factors(number : Int) =
    (1 to number) filter (number % _ == 0)

  def sum(factors: Seq[Int]) =
    factors.foldLeft(0)(_ + _)

  def isPerfect(number: Int) =
    sum(factors(number)) - number == number

  def isAbundant(number: Int) =
    sum(factors(number)) - number > number

  def isDeficient(numner: Int) =
    sum(factors(number)) - number < number

}