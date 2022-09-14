package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int =
    c match {
      case 0 => 1
      case _ => if (c == r) 1 else pascal(c-1, r-1) + pascal(c, r-1)
    }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def balanceIter (chars: List[Char], stack: List[Char]): Boolean =
      chars match {
        case Nil => stack.isEmpty
        case head::tail =>
          head match {
            case '(' => balanceIter(tail, head::stack)
            case ')' => if (stack.isEmpty) false else balanceIter(tail, stack.tail)
            case _ => balanceIter(tail, stack)
          }
      }
    balanceIter(chars, Nil)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def countChangeIter (money: Int, coins: List[Int]):Int = {
      if (money < 0) 0
      else if (money == 0) 1
      else coins match {
        case Nil => 0
        case head::tail => countChangeIter(money, tail) + countChangeIter(money-head, coins)
      }
    }
    countChangeIter(money, coins.sorted(Ordering.Int.reverse))
  }
}
