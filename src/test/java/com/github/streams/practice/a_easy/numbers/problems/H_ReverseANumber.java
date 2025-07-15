package com.github.streams.practice.a_easy.numbers.problems;

import com.github.streams.practice.a_easy.numbers.EasyNumbersProblemSolution;
import com.github.streams.practice.a_easy.numbers.problems.ignore.data.DummyData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

class H_ReverseANumber {

    @Test
    public void reverseANumber() {
        final var input = DummyData.fakerNumber();
        var mySolution = EasyNumbersProblemSolution.reverseANumber(input);
        int yourSolution = IntStream.iterate(input, value -> value > 0, value -> value / 10)
                .map(digit -> digit % 10)
                .reduce(0, (rev, digit) -> rev * 10 + digit);

        Assertions.assertEquals(mySolution, yourSolution);
    }
}
