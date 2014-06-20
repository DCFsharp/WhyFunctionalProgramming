
def toYesOrNo(choice: Int): String = choice match {
  case 1 => "yes"
  case 0 => "no"
  case _ => "error"
}

def toYesOrNo2(choice: Int): String = choice match {
  case 1 | 2 | 3 => "yes"
  case 0 => "no"
  case _ => "error"
}

def f(x: Any): String = x match {
  case i:Int => "integer: " + i
  case _:Double => "a double"
  case s:String => "I want to say " + s
}

def fact(n: Int): Int = n match {
  case 0 => 1
  case n => n * fact(n - 1)
}

/*
def eval(expression : Expression, xValue : Int) : Int = expression match {
  case X() => xValue
  case Const(cst) => cst
  case Add(left, right) => eval(left, xValue) + eval(right, xValue)
  case Mult(left, right) => eval(left, xValue) * eval(right, xValue)
  case Neg(expr) => - eval(expr, xValue)
}*/

bject Test {
  def main(args: Array[String]) {
    val alice = new Person("Alice", 25)
    val bob = new Person("Bob", 32)
    val charlie = new Person("Charlie", 32)

    for (person <- List(alice, bob, charlie)) {
      person match {
        case Person("Alice", 25) => println("Hi Alice!")
        case Person("Bob", 32) => println("Hi Bob!")
        case Person(name, age) =>
          println("Age: " + age + " year, name: " + name + "?")
      }
    }
  }
  // case class, empty one.
  case class Person(name: String, age: Int)
}