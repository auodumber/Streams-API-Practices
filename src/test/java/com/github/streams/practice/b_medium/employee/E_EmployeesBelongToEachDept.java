package com.github.streams.practice.b_medium.employee;

import com.github.streams.practice.b_medium.ProblemSolutions;
import com.github.streams.practice.b_medium.employee.ignore.domain_related.dummy_data.DummyEmployees;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

/// Returns a map where each department is mapped to a list of employee names belonging to that
/// department.
///
/// ### Example:
///
/// ### Input:
/// ```json
///[
///   Employee("John", "Sales"),
///   Employee("Alice", "Marketing"),
///   Employee("Bob", "Sales"),
///   Employee("Charlie", "IT")
///]
///```
///
/// ### Output:
/// ```json
///{
///   "Sales"     : "John", "Bob",
///   "Marketing" : "Alice",
///   "IT"        : "Charlie"
///}
///```
class E_EmployeesBelongToEachDept {
    @Test
    void employeesBelongToEachDept() {
        final var employees = DummyEmployees.randomEmployees();
        final var mySolution = ProblemSolutions.getEmployeesBelongToEachDepartment(employees);
        final var yourSolution = employees.stream()
                .collect(Collectors.groupingBy(e -> e.department(),
                        Collectors.mapping(e -> e.identity().name(),
                                Collectors.toList())));

        Assertions.assertEquals(yourSolution, mySolution);
    }
}
