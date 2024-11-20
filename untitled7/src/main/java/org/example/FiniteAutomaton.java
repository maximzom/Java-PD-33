package org.example;

public class FiniteAutomaton {
    private State currentState;

    public FiniteAutomaton() {
        reset();
    }

    public enum State
    {
        S,
        ONE,
        TWO,
        THREE,
        F
    }

    public void reset()
    {
        currentState = State.S;
    }

    public State processChar(char input)
    {
        System.out.println("Current State: " + currentState + ", Input: " + input); // Debugging
        switch (currentState)
        {
            case S:
                currentState = (input == 'T') ? State.ONE : State.S;
                break;

            case ONE:
                if (input == 'E')
                {
                    currentState = State.TWO;
                }

                else if (input == 'T')
                {
                    currentState = State.ONE;
                }

                else {
                    currentState = State.S;
                }
                break;

            case TWO:
                if (input == 'S')
                {
                    currentState = State.THREE;
                }

                else if (input == 'T')
                {
                    currentState = State.ONE;
                }

                else
                {
                    currentState = State.S; // Reset on invalid character
                }
                break;

            case THREE:
                if (input == 'T') {
                    currentState = State.F;
                }

                else {
                    currentState = State.THREE;
                }
                break;

            case F:
                currentState = (input == 'T') ? State.ONE : State.F;
                break;
        }
        return currentState;
    }

    public State processString(String input)
    {
        reset();
        for (char c : input.toCharArray())
        {
            processChar(c);
        }
        return currentState;
    }

    public State getCurrentState()
    {
        return currentState;
    }
}
