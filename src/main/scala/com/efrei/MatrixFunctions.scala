package com.efrei

object MatrixFunctions {
  def isMagicSquare(matrix: Array[Array[Int]]): Boolean = {
    val n = matrix.length
    val targetSum = n * (n * n + 1) / 2
    var diagonal1Sum = 0
    var diagonal2Sum = 0
    var rowSum = 0
    var colSum = Array.fill(n)(0)

    for (i <- 0 until n) {
      diagonal1Sum += matrix(i)(i)
      diagonal2Sum += matrix(i)(n - i - 1)
      for (j <- 0 until n) {
        rowSum += matrix(i)(j)
        colSum(j) += matrix(i)(j)
      }
      if (rowSum != targetSum) {
        return false
      }
      rowSum = 0
    }

    if (diagonal1Sum != targetSum || diagonal2Sum != targetSum) {
      return false
    }

    colSum.foreach(sum => if (sum != targetSum) return false)

    true
  }

  def isPerfectSquare(matrix: Array[Array[Int]]): Boolean = {
    val n = matrix.length
    val values = (1 to n * n).toSet
    matrix.flatten.toSet == values && isMagicSquare(matrix)
  }

  def main(args: Array[String]): Unit = {
    val matrix1 = Array(Array(8, 1, 6), Array(3, 5, 7), Array(4, 9, 2)) // Magic square
    val matrix2 = Array(Array(1, 14, 16), Array(11, 12, 13), Array(8, 9, 10)) // Not a magic square
    val matrix3 = Array(Array(1, 2, 3), Array(4, 5, 6), Array(7, 8, 9)) // Not a perfect square
    val matrix4 = Array(Array(4, 9, 2), Array(3, 5, 7), Array(8, 1, 6)) // Perfect square
    println(isMagicSquare(matrix1)) // true
    println(isMagicSquare(matrix2)) // false
    println(isPerfectSquare(matrix3)) // false
    println(isPerfectSquare(matrix4)) // true
  }
}
