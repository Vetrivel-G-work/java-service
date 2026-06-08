package com.demo.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculator Unit Tests")
class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    // ─── ADD ───────────────────────────────────────────────────────────────────

    @Test
    @DisplayName("Add two positive numbers")
    void testAddPositiveNumbers() {
        assertEquals(15.0, calculator.add(10, 5));
    }

    @Test
    @DisplayName("Add positive and negative number")
    void testAddPositiveAndNegative() {
        assertEquals(5.0, calculator.add(10, -5));
    }

    @Test
    @DisplayName("Add two negative numbers")
    void testAddTwoNegatives() {
        assertEquals(-15.0, calculator.add(-10, -5));
    }

    @Test
    @DisplayName("Add with zero")
    void testAddWithZero() {
        assertEquals(10.0, calculator.add(10, 0));
    }

    // ─── SUBTRACT ─────────────────────────────────────────────────────────────

    @Test
    @DisplayName("Subtract two positive numbers")
    void testSubtractPositiveNumbers() {
        assertEquals(5.0, calculator.subtract(10, 5));
    }

    @Test
    @DisplayName("Subtract resulting in negative")
    void testSubtractResultingNegative() {
        assertEquals(-5.0, calculator.subtract(5, 10));
    }

    @Test
    @DisplayName("Subtract zero")
    void testSubtractZero() {
        assertEquals(10.0, calculator.subtract(10, 0));
    }

    // ─── MULTIPLY ─────────────────────────────────────────────────────────────

    @Test
    @DisplayName("Multiply two positive numbers")
    void testMultiplyPositiveNumbers() {
        assertEquals(50.0, calculator.multiply(10, 5));
    }

    @Test
    @DisplayName("Multiply by zero")
    void testMultiplyByZero() {
        assertEquals(0.0, calculator.multiply(10, 0));
    }

    @Test
    @DisplayName("Multiply negative numbers")
    void testMultiplyNegativeNumbers() {
        assertEquals(50.0, calculator.multiply(-10, -5));
    }

    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource({
        "2, 3, 6",
        "0, 100, 0",
        "-4, 5, -20",
        "1.5, 2, 3.0"
    })
    @DisplayName("Multiply parameterized cases")
    void testMultiplyParameterized(double a, double b, double expected) {
        assertEquals(expected, calculator.multiply(a, b), 0.0001);
    }

    // ─── DIVIDE ───────────────────────────────────────────────────────────────

    @Test
    @DisplayName("Divide two positive numbers")
    void testDividePositiveNumbers() {
        assertEquals(2.0, calculator.divide(10, 5));
    }

    @Test
    @DisplayName("Divide resulting in decimal")
    void testDivideDecimalResult() {
        assertEquals(3.3333, calculator.divide(10, 3), 0.0001);
    }

    @Test
    @DisplayName("Divide by zero throws IllegalArgumentException")
    void testDivideByZeroThrowsException() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> calculator.divide(10, 0)
        );
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @Test
    @DisplayName("Divide negative by positive")
    void testDivideNegativeByPositive() {
        assertEquals(-2.0, calculator.divide(-10, 5));
    }


