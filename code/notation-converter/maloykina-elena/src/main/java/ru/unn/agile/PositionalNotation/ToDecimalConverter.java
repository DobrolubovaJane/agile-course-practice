package ru.unn.agile.PositionalNotation;

public final class ToDecimalConverter {
    private ToDecimalConverter() {
    }

    public static int convertBinaryToDecimal(final String number) {
        Validator.checkValueToNull(number);
        Validator.checkValueToEmpty(number);
        Validator.checkBinaryValue(number);
        int result = 0;
        int iter = 0;
        String binary = new StringBuilder(number).reverse().toString();
        for (char elem: binary.toCharArray()
             ) {
            result += (elem - '0') << iter++;
        }
        return result;
    }
    public static int convertOctalToDecimal(final String number) {
        Validator.checkValueToNull(number);
        Validator.checkValueToEmpty(number);
        Validator.checkOctalValue(number);
        int result = 0;
        int iter = 0;
        String octal = new StringBuilder(number).reverse().toString();
        for (char elem: octal.toCharArray()
                ) {
            int val = (elem - '0') << iter;
            iter += Constants.OCTAL_ITER;
            result += val;
        }
        return result;
    }
    public static int convertHexToDecimal(final String number) {
        Validator.checkValueToNull(number);
        Validator.checkValueToEmpty(number);
        Validator.checkHexValue(number);
        int result = 0;
        int iter = 0;
        int val;
        String hex = new StringBuilder(number).reverse().toString();
        for (char elem: hex.toCharArray()
                ) {
            if (elem >= 'A') {
                val = (Constants.HEX_A
                        + String.valueOf(elem).toUpperCase().charAt(0) - 'A') << iter;
            } else {
                val = (elem - '0') << iter;
            }
            iter += Constants.HEX_ITER;
            result += val;
        }
        return result;
    }
}
