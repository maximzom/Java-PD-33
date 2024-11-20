package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FiniteAutomatonTest {

    @ParameterizedTest
    @CsvSource({
            "'abcTESTabc', F",
            "'abcTES', THREE",
            "'T', ONE",
            "'TE', TWO",
            "'TES', THREE",
            "'TEST', F",
            "'TESTTEST', F",
            "'abcTEST', F",
            "'TESTabc', F",
            "'TESabc', THREE",
            "'TETEST', F"
    })

    
    void testAutomaton(String input, FiniteAutomaton.State expected) {
        FiniteAutomaton automaton = new FiniteAutomaton();
        assertEquals(expected, automaton.processString(input));
    }
}
