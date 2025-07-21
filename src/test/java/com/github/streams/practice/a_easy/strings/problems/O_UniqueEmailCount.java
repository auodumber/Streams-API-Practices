package com.github.streams.practice.a_easy.strings.problems;

import com.github.streams.practice.b_medium.ProblemSolutions;
import com.github.streams.practice.b_medium.employee.ignore.domain_related.Identity;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import net.datafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/*
 * There is a list of Employees and Employee object has a field called e-mail.
 *
 * Find the list of domains ( gmail.com, yahoo.com..) and the no of occurrences for each domain?
 * */
class O_UniqueEmailCount {
  @Test
  @Disabled
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

    final Map<String, ? extends Number> yourSolution = employees.stream()
            .collect(Collectors.groupingBy(emailString -> emailString.email().substring(emailString.email().indexOf("@")+1),Collectors.counting()));

    Assertions.assertEquals(mySolution, yourSolution);
  }
}
