package com.github.streams.practice.b_medium.employee;

import com.github.streams.practice.b_medium.ProblemSolutions;
import com.github.streams.practice.b_medium.employee.ignore.domain_related.dummy_data.DummyEmployees;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

/// ## Calculates the sum of salaries in each department.
///
/// ### Input:
/// ```json
/// - Employee("John", "Sales", 50000)
/// - Employee("Jane", "Marketing", 60000)
/// - Employee("Bob", "Sales", 70000)
///```
/// ### Output:
///
/// ```json
///{
///   "Sales": 120000,
///   "Marketing": 60000
///}
///```
class C_SumOfSalaryInEachDept {
    @Test
    void sumOfSalariesInEachDepartment() {
        final var employees = DummyEmployees.randomEmployees();
        final var mySolution = ProblemSolutions.getSumOfSalariesOnEachDepartment(employees);
        final var yourSolution = employees.stream()
                .collect(Collectors.groupingBy(e -> e.department().name(),
                        Collectors.collectingAndThen(Collectors.mapping(e -> e.salary(), Collectors.toList()),
                                salary -> salary.stream().mapToLong(s -> s.longValue()).sum())
                ));

        Assertions.assertEquals(mySolution, yourSolution);
    }
}
