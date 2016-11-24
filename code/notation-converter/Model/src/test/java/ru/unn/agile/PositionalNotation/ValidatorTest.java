package ru.unn.agile.PositionalNotation;

import org.junit.Test;

public class ValidatorTest {
    @Test(expected = IllegalArgumentException.class)
    public void checkOnNull() {
        Validator.checkValueToNull(null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void checkOnEmpty() {
        String value = "";
        Validator.checkValueToEmpty(value);
    }
    @Test(expected = IllegalArgumentException.class)
    public void checkBinary1201() {
        String binary = "1201";
        Validator.checkBinaryValue(binary);
    }
    @Test(expected = IllegalArgumentException.class)
    public void checkBinary1a01() {
        String binary = "1a01";
        Validator.checkBinaryValue(binary);
    }
    @Test(expected = IllegalArgumentException.class)
    public void checkOctal19() {
        String octal = "19";
        Validator.checkOctalValue(octal);
    }
    @Test(expected = IllegalArgumentException.class)
    public void checkOctal10a() {
        String octal = "10a";
        Validator.checkOctalValue(octal);
    }
    @Test(expected = IllegalArgumentException.class)
    public void checkDecimal() {
        Validator.checkDecimalValue(-2);
    }
    @Test(expected = IllegalArgumentException.class)
    public void checkHex1r() {
        String hex = "1r";
        Validator.checkHexValue(hex);
    }
    @Test(expected = IllegalArgumentException.class)
    public void checkHex1T() {
        String hex = "1T";
        Validator.checkHexValue(hex);
    }
}
