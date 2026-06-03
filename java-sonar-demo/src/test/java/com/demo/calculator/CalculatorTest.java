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


    // ─── MODULUS ──────────────────────────────────────────────────────────────

    @Test
    @DisplayName("Modulus of positive numbers")
    void testModulusPositive() {
        assertEquals(1.0, calculator.modulus(10, 3));
    }

    @Test
    @DisplayName("Modulus with no remainder")
    void testModulusNoRemainder() {
        assertEquals(0.0, calculator.modulus(10, 5));
    }

    @Test
    @DisplayName("Modulus by zero throws IllegalArgumentException")
    void testModulusByZeroThrowsException() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> calculator.modulus(10, 0)
        );
        assertEquals("Cannot compute modulus with zero divisor", exception.getMessage());
    }
}
