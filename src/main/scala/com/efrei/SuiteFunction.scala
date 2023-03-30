package com.efrei

object SuiteFunction {
  def suite(n: Int): Int = {
    if (n == 0) 1
    else if (n == 1) 2
    else {
      var prev1 = 1
      var prev2 = 2
      var curr = 0
      for (i <- 2 to n) {
        curr = 3 * prev2 + prev1
        prev1 = prev2
        prev2 = curr
      }
      curr
    }
  }

  def main(args: Array[String]): Unit = {
    val n = 5
    val result = suite(n)
    println(s"Result for n = $n: $result")
  }
}
