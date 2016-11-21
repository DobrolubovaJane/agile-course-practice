package ru.unn.agile.PositionalNotation;

public final class Validator {
    private Validator() {
    }
    public static void checkValueToNull(final String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
    }
    public static void checkValueToEmpty(final String value) {
        if ("".equals(value)) {
            throw new IllegalArgumentException("Value is empty");
        }
    }
    public static void checkBinaryValue(final String binary) {
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) > '1' || binary.charAt(i) < '0') {
                throw new IllegalArgumentException("Incorrect binary number");
            }
        }
    }
    public static void checkOctalValue(final String octal) {
        for (int i = 0; i < octal.length(); i++) {
            if (octal.charAt(i) > '7' || octal.charAt(i) < '0') {
                throw new IllegalArgumentException("Incorrect octal number");
            }
        }
    }
    public static void checkDecimalValue(final int decimal) {
        if (decimal < 0) {
            throw new IllegalArgumentException("Enter positive number");
        }
    }
    public static void checkHexValue(final String hex) {
        for (int i = 0; i < hex.length(); i++) {
            if (!(hex.charAt(i) <= '9' && hex.charAt(i) >= '0'
                    || hex.charAt(i) <= 'f' && hex.charAt(i) >= 'a'
                    || hex.charAt(i) <= 'F' && hex.charAt(i) >= 'A')) {
                throw new IllegalArgumentException("Incorrect hex number");
            }
        }
    }
}
