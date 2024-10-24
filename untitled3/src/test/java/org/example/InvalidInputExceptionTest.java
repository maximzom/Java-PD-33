package org.example;

import org.junit.jupiter.api.Test;

import static java.lang.Double.*;
import static org.junit.jupiter.api.Assertions.*;

public class InvalidInputExceptionTest {

    @Test
    public void testInvalidInputException() {
        Exception exception;
        exception = assertThrows(InvalidInputException.class, () -> {
            throw new InvalidInputException("Неправильна операція.");
        });

        //

        assertEquals("Неправильна операція.", exception.getMessage());
        System.out.println("Тест testInvalidInputException проведений.");
    }

    @Test
    public void testInvalidNumberInput() {
        assertThrows(NumberFormatException.class, () -> {
            parseDouble("abc");
        });

        System.out.println("Тест testInvalidNumberInput проведений.");
    }
}
