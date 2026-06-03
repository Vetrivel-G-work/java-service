package com.demo.calculator;

/**
 * Calculator class providing basic arithmetic operations.
 */
public class Calculator {

    /**
     * Adds two numbers.
     */
    public double add(double a, double b) {
        return a + b;
    }

    /**
     * Subtracts b from a.
     */
    public double subtract(double a, double b) {
        return a - b;
    }

    /**
     * Multiplies two numbers.
     */
    public double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Divides a by b.
     * @throws IllegalArgumentException if b is zero
     */
    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }

    /**
     * Returns the square root of a number.
     * @throws IllegalArgumentException if number is negative
     */
    public double squareRoot(double a) {
        if (a < 0) {
            throw new IllegalArgumentException("Cannot compute square root of a negative number");
        }
        return Math.sqrt(a);
    }

    /**
     * Returns a raised to the power of b.
     */
    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    /**
     * Returns the modulus (remainder) of a divided by b.
     * @throws IllegalArgumentException if b is zero
     */
    public double modulus(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot compute modulus with zero divisor");
        }
        return a % b;
    }
}
