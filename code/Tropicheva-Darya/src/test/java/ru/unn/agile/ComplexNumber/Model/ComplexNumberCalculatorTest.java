package ru.unn.agile.ComplexNumber.Model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Дарья on 06.11.2016.
 */
public class ComplexNumberCalculatorTest {
    private float delta = 0.0001f;

    @Test
    public void testCanAddTwoComplexNumbers() {
        ComplexNumber complexNumberA = new ComplexNumber(3.5f, 1.02f);
        ComplexNumber complexNumberB = new ComplexNumber(4.3f, 0);
        ComplexNumber result = new ComplexNumber(7.8f, 1.02f);
        assertEquals(result, CalculatorComplexNumber.add(complexNumberA, complexNumberB));
    }

    @Test
    public void testCanAddTwoNegativeComplexNumbers() {
        ComplexNumber complexNumberA = new ComplexNumber(1.8f, 1);
        ComplexNumber complexNumberB = new ComplexNumber(-3.24f, -3.67f);
        ComplexNumber result = new ComplexNumber(-1.44f, -2.67f);
        assertEquals(result, CalculatorComplexNumber.add(complexNumberA, complexNumberB));
    }

    @Test
    public void testCanSubtractTwoComplexNumbers() {
        ComplexNumber complexNumberA = new ComplexNumber(1, 1);
        ComplexNumber complexNumberB = new ComplexNumber(4, 0.56f);
        ComplexNumber result = new ComplexNumber(-3, 0.44f);
        assertEquals(result, CalculatorComplexNumber.sub(complexNumberA, complexNumberB));
    }

    @Test
    public void testCanMultTwoComplexNumbers() {
        ComplexNumber complexNumberA = new ComplexNumber(2, 1.2f);
        ComplexNumber complexNumberB = new ComplexNumber(0, -1);
        ComplexNumber result = new ComplexNumber(1.2f, -2);
        assertEquals(result, CalculatorComplexNumber.mult(complexNumberA, complexNumberB));
    }

    @Test
    public void testCanMultByZero() {
        ComplexNumber complexNumberA = new ComplexNumber(2, 1.2f);
        ComplexNumber complexNumberB = new ComplexNumber(0, 0);
        ComplexNumber result = new ComplexNumber(0, 0);
        assertEquals(result, CalculatorComplexNumber.mult(complexNumberA, complexNumberB));
    }

    @Test
    public void testCanDivisionTwoComplexNumber() {
        ComplexNumber complexNumberA = new ComplexNumber(2, 1);
        ComplexNumber complexNumberB = new ComplexNumber(1, 1);
        ComplexNumber result = new ComplexNumber(1.5f, -0.5f);
        assertEquals(result, CalculatorComplexNumber.div(complexNumberA, complexNumberB));
    }

    @Test(expected = ArithmeticException.class)
    public void testCanNotDivisionByZero() {
        ComplexNumber complexNumberA = new ComplexNumber(2, 1);
        ComplexNumber complexNumberB = new ComplexNumber(0, 0);
        CalculatorComplexNumber.div(complexNumberA, complexNumberB);
    }

    @Test
    public void testCanAbsComplexNumber() {
        ComplexNumber complexNumber = new ComplexNumber(8, 6);
        float result = 10f;
        assertEquals(result, CalculatorComplexNumber.abs(complexNumber), delta);
    }

    @Test
    public void testCanAbsNegativeComplexNumber() {
        ComplexNumber complexNumber = new ComplexNumber(-8, -6);
        float result = 10f;
        assertEquals(result, CalculatorComplexNumber.abs(complexNumber), delta);
    }

    @Test
    public void testCanGetArgumentComplexNumber() {
        ComplexNumber complexNumber = new ComplexNumber(4, 3);
        double result = 0.643501853;
        assertEquals(result, CalculatorComplexNumber.getArgument(complexNumber), delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCanThrowExceptionOnNullArgument() {
        ComplexNumber complexNumberA = new ComplexNumber(2, 1);
        CalculatorComplexNumber.div(complexNumberA, null);
    }
}
