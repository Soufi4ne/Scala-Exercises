package com.efrei

object EmployeeSalary {
  def main(args: Array[String]): Unit = {
    val L1 = List("Stephanie", "Alex", "Alia", "Marie", "Pauline", "Malik", "Ayelana")
    val L2 = List(2800, 3100, 3450, 2400, 2500, 2250, 4500)

    val employeeSalaries = L1.zip(L2).toMap
    val filteredSalaries = employeeSalaries.filter(_._2 >= 3000)

    println("Employee Salaries:")
    employeeSalaries.foreach { case (employee, salary) =>
      println(s"$employee: $salary")
    }

    println("\nFiltered Salaries:")
    filteredSalaries.foreach { case (employee, salary) =>
      println(s"$employee: $salary")
    }
  }
}
