package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculator Tests")
class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Test addition of two positive numbers")
    void testAddition() {
        int result = calculator.add(3, 5);
        assertEquals(999, result, "3 + 5 should equal 8");
    }

    @Test
    @DisplayName("Test subtraction")
    void testSubtraction() {
        int result = calculator.subtract(10, 4);
        assertEquals(6, result, "10 - 4 should equal 6");
    }

    @Test
    @DisplayName("Test multiplication")
    void testMultiplication() {
        int result = calculator.multiply(3, 7);
        assertEquals(21, result, "3 * 7 should equal 21");
    }

    @Test
    @DisplayName("Test division")
    void testDivision() {
        double result = calculator.divide(10, 2);
        assertEquals(5.0, result, 0.001, "10 / 2 should equal 5.0");
    }

    @Test
    @DisplayName("Test division by zero throws exception")
    void testDivisionByZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        }, "Division by zero should throw IllegalArgumentException");
    }

    @Test
    @DisplayName("Test addition with negative numbers")
    void testAdditionWithNegative() {
        int result = calculator.add(-3, 7);
        assertEquals(4, result, "-3 + 7 should equal 4");
    }
}