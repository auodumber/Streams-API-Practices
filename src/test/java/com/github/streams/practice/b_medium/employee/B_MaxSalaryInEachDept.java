package com.github.streams.practice.b_medium.employee;

import com.github.streams.practice.b_medium.ProblemSolutions;
import com.github.streams.practice.b_medium.employee.ignore.domain_related.dummy_data.DummyEmployees;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.stream.Collectors;

///  ### Given a list of employees, find the maximum salary in each department.
///
///  #### Input
/// ```json
///
///  - Employee(department="Sales", salary=5000)
///  - Employee(department="Sales", salary=6000)
///  - Employee(department="Marketing", salary=4000)
///  - Employee(department="Marketing", salary=7000)
///```
///  #### Output
/// ```json
///  - Sales=6000
///  - Marketing=7000
///```
class B_MaxSalaryInEachDept {

    @Test
    void testMaxSalaryInEachDept() {

        final var employees = DummyEmployees.randomEmployees();

        final var mySolution = ProblemSolutions.getHighestSalaryInEachDepartment(employees);
        final var yourSolution = employees.stream()
                .collect(Collectors.groupingBy(e -> e.department().name(),
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(e -> e.salary())),
                                salary -> salary.get().salary())

                ));

        Assertions.assertEquals(mySolution, yourSolution);
    }
}
