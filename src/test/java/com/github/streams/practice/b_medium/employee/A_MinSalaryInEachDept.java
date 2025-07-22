package com.github.streams.practice.b_medium.employee;

import com.github.streams.practice.b_medium.ProblemSolutions;
import com.github.streams.practice.b_medium.employee.ignore.domain_related.dummy_data.DummyEmployees;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

/// #### Given a list of employees, find the minimum salary in each department.
///
/// ### Input:
/// ```json
/// - Employee(department="Sales", salary=5000)
/// - Employee(department="Sales", salary=6000)
/// - Employee(department="Marketing", salary=4000)
/// - Employee(department="Marketing", salary=7000)
/// ```
/// ### Output:
/// ```json
/// - Sales=5000
/// - Marketing=4000
/// ```

class A_MinSalaryInEachDept {
  @Test
  @Disabled
  void testMinSalaryInEachDepartment() {

    final var employees = DummyEmployees.randomEmployees();

    final var mySolution = ProblemSolutions.getMinSalaryInEachDepartment(employees);
    final var yourSolution = employees.stream()
                    .collect(Collectors.toMap(e -> e.department().toString(),e -> e.salary(),(oldValue,newValue) -> Long.min(oldValue,newValue)));

    Assertions.assertEquals(mySolution, yourSolution);
  }
}
