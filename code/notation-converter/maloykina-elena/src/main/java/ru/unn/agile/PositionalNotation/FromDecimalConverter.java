package ru.unn.agile.PositionalNotation;

public final class FromDecimalConverter {
    private FromDecimalConverter() {
    }

    public static String convertToBinary(final int number) {
        Validator.checkDecimalValue(number);
        String result = "";
        int decimal = number;
        do {
            result = result + (int) (decimal & Constants.BINARY_MULT);
            decimal >>>= 1;
        } while (decimal != 0);
        return new StringBuilder(result).reverse().toString();
    }
    public static String convertToOctal(final int number) {
        Validator.checkDecimalValue(number);
        String result = "";
        int decimal = number;
        do {
            result = result + Constants.OCTALS[(int) (decimal & Constants.OCTAL_MULT)];
            decimal >>>= Constants.OCTAL_ITER;
        } while (decimal != 0);
        return new StringBuilder(result).reverse().toString();
    }
    public static String convertToHex(final int number) {
        Validator.checkDecimalValue(number);
        String result = "";
        int decimal = number;
        int iter = 0;
        do {
            iter++;
            result = result + Constants.HEX[(int) (decimal & Constants.HEX_MULT)];
            decimal >>>= Constants.HEX_ITER;
        } while (decimal != 0);
        if (iter > 1) {
            return new StringBuilder(result).reverse().toString();
        } else {
            return result;
        }
    }
}
