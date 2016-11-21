package ru.unn.agile.PositionalNotation;

import org.junit.Test;
import static org.junit.Assert.*;

public class ConverterTest {
    @Test
    public void convert101FromBinaryToDecimal() {
        String binary = "101";
        int decimal = Converter.binaryToDecimal(binary);
        assertEquals(5, decimal);
    }
    @Test
    public void convert0FromBinaryToOctal() {
        String binary = "0";
        String octal = Converter.binaryToOctal(binary);
        assertEquals("0", octal);
    }
    @Test
    public void convert1111FromBinaryToOctal() {
        String binary = "1111";
        String octal = Converter.binaryToOctal(binary);
        assertEquals("17", octal);
    }
    @Test
    public void convert10101FromBinaryToOctal() {
        String binary = "10101";
        String octal = Converter.binaryToOctal(binary);
        assertEquals("25", octal);
    }
    @Test
    public void convert0FromBinaryToHex() {
        String binary = "0";
        String hex = Converter.binaryToHex(binary);
        assertEquals("0", hex);
    }
    @Test
    public void convert111FromBinaryToHex() {
        String binary = "111";
        String hex = Converter.binaryToHex(binary);
        assertEquals("7", hex);
    }
    @Test
    public void convert11101FromBinaryToHex() {
        String binary = "11101";
        String hex = Converter.binaryToHex(binary);
        assertEquals("1d", hex);
    }
    @Test
    public void convert3FromOctalToBinary() {
        String octal = "3";
        String binary = Converter.octalToBinary(octal);
        assertEquals("11", binary);
    }
    @Test
    public void convert11FromOctalToBinary() {
        String octal = "11";
        String binary = Converter.octalToBinary(octal);
        assertEquals("1001", binary);
    }
    @Test
    public void convert37FromOctalToBinary() {
        String octal = "37";
        String binary = Converter.octalToBinary(octal);
        assertEquals("11111", binary);
    }
    @Test
    public void convert25FromOctalToDecimal() {
        String octal = "25";
        int decimal = Converter.octalToDecimal(octal);
        assertEquals(21, decimal);
    }
    @Test
    public void convert3FromOctalToHex() {
        String octal = "3";
        String hex = Converter.octalToHex(octal);
        assertEquals("3", hex);
    }
    @Test
    public void convert17FromOctalToHex() {
        String octal = "17";
        String hex = Converter.octalToHex(octal);
        assertEquals("f", hex);
    }
    @Test
    public void convert32FromOctalToHex() {
        String octal = "32";
        String hex = Converter.octalToHex(octal);
        assertEquals("1a", hex);
    }
    @Test
    public void convert4FromDecimalToBinary() {
        String binary = Converter.decimalToBinary(4);
        assertEquals("100", binary);
    }
    @Test
    public void convert5FromDecimalToOctal() {
        String octal = Converter.decimalToOctal(5);
        assertEquals("5", octal);
    }
    @Test
    public void convert6FromDecimalToHex() {
        String hex = Converter.decimalToHex(6);
        assertEquals("6", hex);
    }
    @Test
    public void convert7FromHexBinary() {
        String hex = "7";
        String binary = Converter.hexToBinary(hex);
        assertEquals("111", binary);
    }
    @Test
    public void convert14aFromHexToBinary() {
        String hex = "14a";
        String binary = Converter.hexToBinary(hex);
        assertEquals("101001010", binary);
    }
    @Test
    public void convert13f40FromHexToBinary() {
        String hex = "13f40";
        String binary = Converter.hexToBinary(hex);
        assertEquals("10011111101000000", binary);
    }
    @Test
    public void convert8FromHexToOctal() {
        String hex = "8";
        String octal = Converter.hexToOctal(hex);
        assertEquals("10", octal);
    }
    @Test
    public void convert14aFromHexToOctal() {
        String hex = "14a";
        String octal = Converter.hexToOctal(hex);
        assertEquals("512", octal);
    }
    @Test
    public void convert19FromHexToOctal() {
        String hex = "19";
        String octal = Converter.hexToOctal(hex);
        assertEquals("31", octal);
    }
    @Test
    public void converter1bFromHexToDecimal() {
        String hex = "1b";
        int decimal = Converter.hexToDecimal(hex);
        assertEquals(27, decimal);
    }
}
