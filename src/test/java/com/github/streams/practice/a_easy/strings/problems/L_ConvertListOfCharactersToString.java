package com.github.streams.practice.a_easy.strings.problems;

import com.github.streams.practice.a_easy.strings.StringProblemsSolution;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class L_ConvertListOfCharactersToString {
  @Test
  void convertListOfCharactersToString() {
    var listOfCharacters =
        List.of(
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
            'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
    var mySolution = StringProblemsSolution.convertListOfCharactersToString(listOfCharacters);
    var yourSolution = listOfCharacters.stream().map(c -> String.valueOf(c)).collect(Collectors.joining());
    Assertions.assertEquals(mySolution, yourSolution);
  }
}
