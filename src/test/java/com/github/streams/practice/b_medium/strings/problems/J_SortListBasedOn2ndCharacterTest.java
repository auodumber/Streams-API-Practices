package com.github.streams.practice.b_medium.strings.problems;

import com.github.streams.practice.b_medium.strings.StringProblemsSolution;
import net.datafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

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
    @Disabled
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
        List<String> yourSolution = input.stream().sorted(Comparator.comparing(str -> str.charAt(1))).toList();
                        Assertions.assertEquals(mySolution, yourSolution);
    }
}
