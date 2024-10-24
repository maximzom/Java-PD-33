package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArithmeticExceptionTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void testDivideByZero() {
        Exception exception;
        exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(5, 0);
        });

        assertEquals("Ділення на нуль не допускається.", exception.getMessage());
        System.out.println("Тест testDivideByZero проведений.");
    }
}