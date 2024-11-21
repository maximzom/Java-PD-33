package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class FiniteAutomatonTest {
    
    static Stream<org.junit.jupiter.params.provider.Arguments> provideStringsForAutomaton() {
        return Stream.of(
                arguments("abcTESTabc", FiniteAutomaton.State.F),
                arguments("abcTES", FiniteAutomaton.State.THREE),
                arguments("T", FiniteAutomaton.State.ONE),
                arguments("TE", FiniteAutomaton.State.TWO),
                arguments("TES", FiniteAutomaton.State.THREE),
                arguments("TEST", FiniteAutomaton.State.F),
                arguments("TESTTEST", FiniteAutomaton.State.F),
                arguments("abcTEST", FiniteAutomaton.State.F),
                arguments("TESTabc", FiniteAutomaton.State.F),
                arguments("TESabc", FiniteAutomaton.State.THREE),
                arguments("TETEST", FiniteAutomaton.State.F)
        );
    }

    @ParameterizedTest
    @MethodSource("provideStringsForAutomaton")
    void testAutomaton(String input, FiniteAutomaton.State expected) {
        FiniteAutomaton automaton = new FiniteAutomaton();
        assertEquals(expected, automaton.processString(input));
    }
}
