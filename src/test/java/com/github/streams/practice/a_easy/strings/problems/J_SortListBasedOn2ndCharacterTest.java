package com.github.streams.practice.a_easy.strings.problems;

import com.github.streams.practice.a_easy.strings.StringProblemsSolution;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.datafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class J_SortListBasedOn2ndCharacterTest {
  /**
   * This test creates a list of random names and passes it to the sortListBasedOn2ndCharacter
   * method. The expected result is compared to the actual result to verify the correctness of the
   * method.
   *
   * @author @ZahidKhan
   * @see StringProblemsSolution#sortListBasedOn2ndCharacter(List)
   */
  @Test
  void testSortListBasedOn2ndCharacter() {
    final var fakePersons = new Faker().name();
    List<String> input =
        List.of(
            fakePersons.name(),
            fakePersons.name(),
            fakePersons.name(),
            fakePersons.name(),
            fakePersons.name(),
            fakePersons.name(),
            fakePersons.name(),
            fakePersons.name(),
            fakePersons.name(),
            fakePersons.name(),
            fakePersons.name(),
            fakePersons.name(),
            fakePersons.name(),
            fakePersons.name(),
            fakePersons.name(),
            fakePersons.name(),
            fakePersons.name(),
            fakePersons.name(),
            fakePersons.name(),
            fakePersons.name(),
            fakePersons.name(),
            fakePersons.name(),
            fakePersons.name());

    List<String> mySolution = StringProblemsSolution.sortListBasedOn2ndCharacter(input);

//    Comparator<String> basedOnSecondChar = (o1, o2) -> String.valueOf((char) o1.charAt(1)).compareTo(String.valueOf((char)o2.charAt(1)));
//    List<String> yourSolution = input.stream().sorted(basedOnSecondChar).toList();

    List<String> yourSolution = input.stream().sorted(Comparator.comparing(s -> s.charAt(1))).toList();

    Assertions.assertEquals(mySolution, yourSolution);
  }
}
