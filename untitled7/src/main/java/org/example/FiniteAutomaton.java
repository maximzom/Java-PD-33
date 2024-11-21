package org.example;

public class FiniteAutomaton {
    private State currentState;

    public FiniteAutomaton() {
        reset();
    }

    public enum State {
        S,
        ONE,
        TWO,
        THREE,
        F
    }

    public void reset() {
        currentState = State.S;
    }

    public State processChar(char input) {
        switch (currentState) {
            case S:
                currentState = (input == 'T') ? State.ONE : State.S;
                break;
            case ONE:
                currentState = (input == 'E') ? State.TWO : (input == 'T') ? State.ONE : State.S;
                break;
            case TWO:
                currentState = (input == 'S') ? State.THREE : (input == 'T') ? State.ONE : State.S;
                break;
            case THREE:
                currentState = (input == 'T') ? State.F : State.S;
                break;
            case F:
                currentState = State.F;
                break;
        }
        return currentState;
    }

    public State processString(String input) {
        reset();
        for (char c : input.toCharArray()) {
            processChar(c);
        }
        return currentState;
    }

    public State getCurrentState() {
        return currentState;
    }
}
