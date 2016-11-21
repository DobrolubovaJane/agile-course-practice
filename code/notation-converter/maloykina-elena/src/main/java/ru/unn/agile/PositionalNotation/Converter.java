package ru.unn.agile.PositionalNotation;

public final class Converter {
    private Converter() {
    }

    public static String binaryToOctal(final String binary) {
        int decimal = ToDecimalConverter.convertBinaryToDecimal(binary);
        return  FromDecimalConverter.convertToOctal(decimal);
    }
    public static int binaryToDecimal(final String binary) {
        return ToDecimalConverter.convertBinaryToDecimal(binary);
    }
    public static String binaryToHex(final String binary) {
        int decimal = ToDecimalConverter.convertBinaryToDecimal(binary);
        return FromDecimalConverter.convertToHex(decimal);
    }
    public static String octalToBinary(final String octal) {
        int decimal = ToDecimalConverter.convertOctalToDecimal(octal);
        return FromDecimalConverter.convertToBinary(decimal);
    }
    public static int octalToDecimal(final String octal) {
        return ToDecimalConverter.convertOctalToDecimal(octal);
    }
    public static String octalToHex(final String octal) {
        int decimal = ToDecimalConverter.convertOctalToDecimal(octal);
        return FromDecimalConverter.convertToHex(decimal);
    }
    public static String decimalToBinary(final int decimal) {
        return FromDecimalConverter.convertToBinary(decimal);
    }
    public static String decimalToOctal(final int decimal) {
        return FromDecimalConverter.convertToOctal(decimal);
    }
    public static String decimalToHex(final int decimal) {
        return FromDecimalConverter.convertToHex(decimal);
    }
    public static String hexToBinary(final String hex) {
        int decimal = ToDecimalConverter.convertHexToDecimal(hex);
        return FromDecimalConverter.convertToBinary(decimal);
    }
    public static String hexToOctal(final String hex) {
        int decimal = ToDecimalConverter.convertHexToDecimal(hex);
        return FromDecimalConverter.convertToOctal(decimal);
    }
    public static int hexToDecimal(final String hex) {
        return ToDecimalConverter.convertHexToDecimal(hex);
    }
}
