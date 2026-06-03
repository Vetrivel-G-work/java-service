package com.demo.calculator;

/**
 * Main entry point for the Calculator application.
 */
public class Main {

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        System.out.println("=== Calculator Demo ===");
        System.out.println("10 + 5  = " + calc.add(10, 5));
        System.out.println("10 - 5  = " + calc.subtract(10, 5));
        System.out.println("10 * 5  = " + calc.multiply(10, 5));
        System.out.println("10 / 5  = " + calc.divide(10, 5));
        System.out.println("sqrt(9) = " + calc.squareRoot(9));
        System.out.println("2 ^ 8   = " + calc.power(2, 8));
        System.out.println("10 % 3  = " + calc.modulus(10, 3));
        System.out.println("======================");
    }
}
