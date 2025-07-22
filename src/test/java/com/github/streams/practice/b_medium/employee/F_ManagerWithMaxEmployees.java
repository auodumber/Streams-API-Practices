package com.github.streams.practice.b_medium.employee;

import com.github.streams.practice.b_medium.ProblemSolutions;
import com.github.streams.practice.b_medium.employee.ignore.domain_related.Employee;
import com.github.streams.practice.b_medium.employee.ignore.domain_related.dummy_data.DummyEmployees;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.stream.Collectors;

class F_ManagerWithMaxEmployees {

    ///  Returns the manager with the maximum number of employees.
    ///
    /// Given a list of employees as input, groups them by their managers, and returns
    /// the manager with the most employees.
    ///
    /// ### Example:
    ///
    /// #### Input:
    /// ```json
    ///   Employee("John", "Alice"), // John's manager is Alice
    ///   Employee("Bob", "Alice"), // Bob's manager is Alice
    ///   Employee("Charlie", "David"), // Charlie's manager is David
    ///   Employee("David", null) // David has no manager
    ///```
    ///
    ///
    /// #### Output:
    /// ```json
    /// "Alice"
    ///```
    /// Explanation: (since Alice has 2 employees: John and Bob)
    @Test
    void findManagerWithMaxEmployeesTest() {
        final var employees = DummyEmployees.randomEmployees();
        final var mySolution = ProblemSolutions.getManagerIdHavingMaxEmployees(employees);
        final var yourSolution = employees.stream()
                .collect(Collectors.groupingBy(Employee::managerId, Collectors.counting()))
                .values().stream().max(Comparator.comparingLong(e -> e)).orElse(-1L);

        Assertions.assertEquals(mySolution, yourSolution);
    }
}
