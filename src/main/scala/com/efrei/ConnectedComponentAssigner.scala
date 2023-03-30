package com.efrei

object ConnectedComponentAssigner {
  def findNextOne(arr: Array[Int], start: Int): Option[Int] = {
    var i = start
    while (i < arr.length && arr(i) != 1) {
      i += 1
    }
    if (i < arr.length) Some(i) else None
  }

  def propagateValue(arr: Array[Int], start: Int, value: Int): Unit = {
    if (start >= arr.length || arr(start) != 1) return
    arr(start) = value
    propagateValue(arr, start + 1, value)
    propagateValue(arr, start - 1, value)
  }

  def assignConnectedComponentValues(arr: Array[Int]): Unit = {
    var i = 0
    var value = 2
    while (i < arr.length) {
      findNextOne(arr, i) match {
        case Some(start) =>
          propagateValue(arr, start, value)
          value += 1
          i = start + 1
        case None => i = arr.length
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(0, 1, 1, 0, 1, 0, 1, 1, 1)
    assignConnectedComponentValues(arr)
    println(arr.mkString(", "))
  }
}
