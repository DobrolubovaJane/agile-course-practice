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
        Complex complexNumberA = new Complex(3.5f, 1.02f);
        Complex complexNumberB = new Complex(4.3f, 0);
        Complex result = new Complex(7.8f, 1.02f);
        assertEquals(result, CalculatorComplexNumber.add(complexNumberA, complexNumberB));
    }

    @Test
    public void testCanAddTwoNegativeComplexNumbers() {
        Complex complexNumberA = new Complex(1.8f, 1);
        Complex complexNumberB = new Complex(-3.24f, -3.67f);
        Complex result = new Complex(-1.44f, -2.67f);
        assertEquals(result, CalculatorComplexNumber.add(complexNumberA, complexNumberB));
    }

    @Test
    public void testCanSubtractTwoComplexNumbers() {
        Complex complexNumberA = new Complex(1, 1);
        Complex complexNumberB = new Complex(4, 0.56f);
        Complex result = new Complex(-3, 0.44f);
        assertEquals(result, CalculatorComplexNumber.sub(complexNumberA, complexNumberB));
    }

    @Test
    public void testCanMultTwoComplexNumbers() {
        Complex complexNumberA = new Complex(2, 1.2f);
        Complex complexNumberB = new Complex(0, -1);
        Complex result = new Complex(1.2f, -2);
        assertEquals(result, CalculatorComplexNumber.mult(complexNumberA, complexNumberB));
    }

    @Test
    public void testCanMultByZero() {
        Complex complexNumberA = new Complex(2, 1.2f);
        Complex complexNumberB = new Complex(0, 0);
        Complex result = new Complex(0, 0);
        assertEquals(result, CalculatorComplexNumber.mult(complexNumberA, complexNumberB));
    }

    @Test
    public void testCanDivisionTwoComplex() {
        Complex complexNumberA = new Complex(2, 1);
        Complex complexNumberB = new Complex(1, 1);
        Complex result = new Complex(1.5f, -0.5f);
        assertEquals(result, CalculatorComplexNumber.div(complexNumberA, complexNumberB));
    }

    @Test(expected = ArithmeticException.class)
    public void testCanNotDivisionByZero() {
        Complex complexNumberA = new Complex(2, 1);
        Complex complexNumberB = new Complex(0, 0);
        CalculatorComplexNumber.div(complexNumberA, complexNumberB);
    }

    @Test
    public void testCanAbsComplex() {
        Complex complexNumber = new Complex(8, 6);
        float result = 10f;
        assertEquals(result, CalculatorComplexNumber.abs(complexNumber), delta);
    }

    @Test
    public void testCanAbsNegativeComplex() {
        Complex complexNumber = new Complex(-8, -6);
        float result = 10f;
        assertEquals(result, CalculatorComplexNumber.abs(complexNumber), delta);
    }

    @Test
    public void testCanGetArgumentComplex() {
        Complex complexNumber = new Complex(4, 3);
        double result = 0.643501853;
        assertEquals(result, CalculatorComplexNumber.getArgument(complexNumber), delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCanThrowExceptionOnNullArgument() {
        Complex complexNumberA = new Complex(2, 1);
        CalculatorComplexNumber.div(complexNumberA, null);
    }
}
