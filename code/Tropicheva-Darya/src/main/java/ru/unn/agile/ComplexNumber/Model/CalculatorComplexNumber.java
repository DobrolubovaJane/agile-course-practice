package ru.unn.agile.ComplexNumber.Model;

/**
 * Created by Дарья on 07.11.2016.
 */
public final class CalculatorComplexNumber {
    private CalculatorComplexNumber() {
    }

    public static Complex add(final Complex complexA, final Complex complexB) {
        checkNonNullNumber(complexA);
        checkNonNullNumber(complexB);
        return new Complex(complexA.getReal() + complexB.getReal(),
                complexA.getImaginary() + complexB.getImaginary());
    }

    public static Complex sub(final Complex complexA, final Complex complexB) {
        checkNonNullNumber(complexA);
        checkNonNullNumber(complexB);
        return new Complex(complexA.getReal() - complexB.getReal(),
                complexA.getImaginary() - complexB.getImaginary());
    }

    public static Complex mult(final Complex complexA, final Complex complexB) {
        checkNonNullNumber(complexA);
        checkNonNullNumber(complexB);
        float real = complexA.getReal() * complexB.getReal()
                - complexA.getImaginary() * complexB.getImaginary();
        float im = complexA.getReal() * complexB.getImaginary()
                + complexA.getImaginary() * complexB.getReal();
        return new Complex(real, im);
    }

    private static void checkNonZeroNumber(final Complex complexNumber) {
        if (Float.compare(complexNumber.getReal(), 0.f) == 0
                && Float.compare(complexNumber.getImaginary(), 0.f) == 0) {
            throw new ArithmeticException("Divider can't be zero");
        }
    }

    private static void checkNonNullNumber(final Complex complexNumber) {
        if (complexNumber == null) {
            throw new IllegalArgumentException("Parameter can't be null");
        }
    }

    public static Complex div(final Complex complexA, final Complex complexB) {
        checkNonNullNumber(complexA);
        checkNonNullNumber(complexB);
        checkNonZeroNumber(complexB);
        float factor = complexB.getReal() * complexB.getReal()
                + complexB.getImaginary() * complexB.getImaginary();
        Complex representComplexB = new Complex(complexB.getReal() / factor,
                -complexB.getImaginary() / factor);
        return mult(complexA, representComplexB);
    }

    public static float abs(final Complex complexNumber) {
        checkNonNullNumber(complexNumber);
        return (float) Math.hypot(complexNumber.getReal(), complexNumber.getImaginary());
    }

    public static double getArgument(final Complex complexNumber) {
        checkNonNullNumber(complexNumber);
        return Math.atan2((double) complexNumber.getImaginary(), (double) complexNumber.getReal());
    }
}
