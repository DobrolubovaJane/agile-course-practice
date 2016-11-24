package ru.unn.agile.PositionalNotation;

public final class Constants {
    public static final int OCTAL_ITER = 3;
    public static final int HEX_ITER = 4;

    public static final int HEX_A = 10;

    public static final byte BINARY_MULT = (byte) 1;
    public static final byte OCTAL_MULT = (byte) 7;
    public static final byte HEX_MULT = (byte) 15;

    public static final char[] OCTALS = {
            '0', '1', '2', '3', '4', '5', '6', '7'
    };
    public static final char[] HEX = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
    };

    private Constants() {
    }
}
