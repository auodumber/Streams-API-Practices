package com.github.streams.practice.b_medium.strings.problems;

import com.github.streams.practice.b_medium.strings.StringProblemsSolution;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Auodumbar
 */
public class S_SplitCharacterRuns {
    /**
     * Given a string, split it into a list of strings consisting of
     * consecutive characters from the original string. Note: this is
     * similar to Python's itertools.groupby function, but it differs
     * from Java's Collectors.groupingBy() collector.
     */
    @Test
    public void h4_splitCharacterRuns() {
        String input = "aaaaabbccccdeeeeeeaaafff";
        List<String> mySolution = StringProblemsSolution.splitCharacterRuns(input);
        List<String> yourSolution = new ArrayList<>();

        input.chars().mapToObj(i -> String.valueOf((char) i))
                .reduce((a, b) -> {
                    if (a.contains(b)) {
                        a = a.concat(b);
                    } else {
                        yourSolution.add(a);
                        a = b;
                    }
                    return a;
                }).ifPresent(str -> yourSolution.add(str));

        assertEquals(mySolution.toString(), yourSolution.toString());
    }
}
