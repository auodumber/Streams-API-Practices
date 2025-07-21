package com.github.streams.practice.a_easy.strings.problems;

import com.github.streams.practice.a_easy.strings.StringProblemsSolution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class K_FindDuplicateStrings {
    @Test
    void findDuplicateStrings() {
        final var input = List.of("Hellow", "World", "How", "are", "you", "How", "are", "you");
        final var mySolution = StringProblemsSolution.findDuplicateStrings(input);

        final var yourSolution = input.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(en -> en.getValue() > 1)
                .map(en -> en.getKey()).toList();

        Assertions.assertEquals(mySolution, yourSolution);
    }
}
