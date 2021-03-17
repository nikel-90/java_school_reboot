package ru.sber.javaschool.homework.hw1.Calculator;

import org.junit.Assert;
import org.junit.Test;


public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    public void checkSimpleOperation() {
        String actual = calculator.evaluate("2+2");
        Assert.assertEquals("4", actual);
    }

    @Test
    public void checkTheBrackets() {
        String actual = calculator.evaluate("(2*5)/10");
        Assert.assertEquals("1", actual);
    }

    @Test
    public void checkComplex() {
        String actual = calculator.evaluate("((20*5)/10+8)/(36/2)");
        Assert.assertEquals("1", actual);
    }
}