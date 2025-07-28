package com.github.streams.practice.b_medium.strings.problems;

import com.github.streams.practice.b_medium.strings.StringProblemsSolution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class L_ConvertListOfCharactersToString {
    @Test
    void convertListOfCharactersToString() {
        var listOfCharacters =
                List.of(
                        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
                        'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
        var mySolution = StringProblemsSolution.convertListOfCharactersToString(listOfCharacters);
        var yourSolution = listOfCharacters.stream().map(a -> String.valueOf(a)).collect(Collectors.joining());
        Assertions.assertEquals(mySolution, yourSolution);
    }
}
