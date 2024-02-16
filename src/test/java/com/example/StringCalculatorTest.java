package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {
    @Test
    public void testAddWithEmptyString() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void testAddWithSingleNumber() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(1, calculator.add("1"));
    }

    @Test
    public void testAddWithTwoNumbers() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.add("1,2"));
    }
    @Test
    public void testAddWithCustomDelimiter() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.add("//;\n1;2"));
    }
    @Test
    public void testAddWithNegativeNumber() {
        StringCalculator calculator = new StringCalculator();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("-1,2,-3");
        });

        assertEquals("Negatives not allowed: -1, -3", exception.getMessage());
    }
    @Test
    public void testAddIgnoringNumbersGreaterThan1000() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(2, calculator.add("2,1001"));
    }
    @Test
    public void testAddWithDelimiterOfAnyLength() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("//[***]\n1***2***3"));
    }
    @Test
    public void testAddWithMultipleDelimiters() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("//[*][%]\n1*2%3"));
    }
    @Test
    public void testAddWithMultipleDelimitersLongerThanOneChar() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("//[***][%%%]\n1***2%%%3"));
    }
}