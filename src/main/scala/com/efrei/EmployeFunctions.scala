package com.efrei

object EmployeFunctions {
  val list_emp = List(("13", "cadre", 2020, 3500), ("15", "ingénieur", 2018, 2800), ("14", "cadre", 2022, 3100), ("16", "apprenti", 2023, 1300), ("17", "cadre", 2014, 4000))

  def main(args: Array[String]): Unit = {
    // Maximum salary of employees
    val maxSalary = list_emp.map(_._4).max
    println(s"Maximum salary of employees: $maxSalary")

    // Average salary of executives
    val (execSalaries, execCount) = list_emp.foldLeft((0, 0)) {
      case ((sum, count), emp) if emp._2 == "cadre" =>
        (sum + emp._4, count + 1)
      case (acc, _) => acc
    }
    val avgExecSalary = if (execCount > 0) execSalaries / execCount else 0
    println(s"Average salary of executives: $avgExecSalary")
  }
}
