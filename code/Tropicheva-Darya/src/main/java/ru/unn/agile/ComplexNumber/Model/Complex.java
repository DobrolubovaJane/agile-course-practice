package ru.unn.agile.ComplexNumber.Model;

/**
 * Created by Дарья on 07.11.2016.
 */
public class Complex {
    private final float real;
    private final float imaginary;
    private static final int HASHCODE = 31;
    private static final float ZERO = 0.00001f;

    public Complex(final float re, final float im) {
        this.real = re;
        this.imaginary = im;
    }

    @Override
    public String toString() {
        return "Complex{" + "" + real + " + i" + imaginary + '}';
    }

    public float getReal() {
        return this.real;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Complex that = (Complex) o;

        if (Float.compare(that.real, real) != 0) {
            return false;
        }
        return Float.compare(that.imaginary, imaginary) == 0;

    }

    @Override
    public int hashCode() {
        int result = (Math.abs(real) <= ZERO ? Float.floatToIntBits(real) : 0);
        result = HASHCODE * result
                + (Math.abs(imaginary) <= ZERO ? Float.floatToIntBits(imaginary) : 0);
        return result;
    }

    public float getImaginary() {
        return this.imaginary;
    }

}
