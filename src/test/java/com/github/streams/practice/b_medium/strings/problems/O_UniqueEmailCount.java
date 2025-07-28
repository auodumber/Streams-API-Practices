package com.github.streams.practice.b_medium.strings.problems;

import com.github.streams.practice.b_medium.ProblemSolutions;
import com.github.streams.practice.b_medium.employee.ignore.domain_related.Identity;
import net.datafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * There is a list of Employees and Employee object has a field called e-mail.
 *
 * Find the list of domains ( gmail.com, yahoo.com..) and the no of occurrences for each domain?
 * */
class O_UniqueEmailCount {
    @Test
    void findUniqueDomainsWithCount() {
        final var instance = new Faker();
        final var employees =
                List.of(
                        new Identity(instance.internet().emailAddress(), ""),
                        new Identity(instance.internet().emailAddress(), ""),
                        new Identity(instance.internet().emailAddress(), ""),
                        new Identity(instance.internet().emailAddress(), ""),
                        new Identity(instance.internet().emailAddress(), ""),
                        new Identity(instance.internet().emailAddress(), ""),
                        new Identity(instance.internet().emailAddress(), ""),
                        new Identity(instance.internet().emailAddress(), ""),
                        new Identity(instance.internet().emailAddress(), ""),
                        new Identity(instance.internet().emailAddress(), ""),
                        new Identity(instance.internet().emailAddress(), ""));

        final var mySolution = ProblemSolutions.findUniqueDomainsCount(employees);
        Function<Identity, String> emailClassifier = (identity) -> identity.email().substring(identity.email().indexOf("@") + 1);
        final Map<String, ? extends Number> yourSolution = employees.stream()
                .collect(Collectors.groupingBy(emailClassifier, Collectors.counting()));

        Assertions.assertEquals(mySolution, yourSolution);
    }
}
