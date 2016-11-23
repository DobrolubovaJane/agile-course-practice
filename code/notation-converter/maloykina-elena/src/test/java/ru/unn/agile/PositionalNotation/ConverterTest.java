package ru.unn.agile.PositionalNotation;

import org.junit.Test;
import static org.junit.Assert.*;

public class ConverterTest {
    @Test
    public void convert101FromBinaryToDecimal() {
        String binary = "101";
        String decimal = Converter.convert(binary, Notations.BINARY, Notations.DECIMAL);
        assertEquals("5", decimal);
    }
    @Test
    public void convert0FromBinaryToOctal() {
        String binary = "0";
        String octal = Converter.convert(binary, Notations.BINARY, Notations.OCTAL);
        assertEquals("0", octal);
    }
    @Test
    public void convert1111FromBinaryToOctal() {
        String binary = "1111";
        String octal = Converter.convert(binary, Notations.BINARY, Notations.OCTAL);
        assertEquals("17", octal);
    }
    @Test
    public void convert10101FromBinaryToOctal() {
        String binary = "10101";
        String octal = Converter.convert(binary, Notations.BINARY, Notations.OCTAL);
        assertEquals("25", octal);
    }
    @Test
    public void convert0FromBinaryToHex() {
        String binary = "0";
        String hex = Converter.convert(binary, Notations.BINARY, Notations.HEX);
        assertEquals("0", hex);
    }
    @Test
    public void convert111FromBinaryToHex() {
        String binary = "111";
        String hex = Converter.convert(binary, Notations.BINARY, Notations.HEX);
        assertEquals("7", hex);
    }
    @Test
    public void convert11101FromBinaryToHex() {
        String binary = "11101";
        String hex = Converter.convert(binary, Notations.BINARY, Notations.HEX);
        assertEquals("1d", hex);
    }
    @Test
    public void convert3FromOctalToBinary() {
        String octal = "3";
        String binary = Converter.convert(octal, Notations.OCTAL, Notations.BINARY);
        assertEquals("11", binary);
    }
    @Test
    public void convert11FromOctalToBinary() {
        String octal = "11";
        String binary = Converter.convert(octal, Notations.OCTAL, Notations.BINARY);
        assertEquals("1001", binary);
    }
    @Test
    public void convert37FromOctalToBinary() {
        String octal = "37";
        String binary = Converter.convert(octal, Notations.OCTAL, Notations.BINARY);
        assertEquals("11111", binary);
    }
    @Test
    public void convert25FromOctalToDecimal() {
        String octal = "25";
        String decimal = Converter.convert(octal, Notations.OCTAL, Notations.DECIMAL);
        assertEquals("21", decimal);
    }
    @Test
    public void convert3FromOctalToHex() {
        String octal = "3";
        String hex = Converter.convert(octal, Notations.OCTAL, Notations.HEX);
        assertEquals("3", hex);
    }
    @Test
    public void convert17FromOctalToHex() {
        String octal = "17";
        String hex = Converter.convert(octal, Notations.OCTAL, Notations.HEX);
        assertEquals("f", hex);
    }
    @Test
    public void convert32FromOctalToHex() {
        String octal = "32";
        String hex = Converter.convert(octal, Notations.OCTAL, Notations.HEX);
        assertEquals("1a", hex);
    }
    @Test
    public void convert4FromDecimalToBinary() {
        String binary = Converter.convert("4", Notations.DECIMAL, Notations.BINARY);
        assertEquals("100", binary);
    }
    @Test
    public void convert5FromDecimalToOctal() {
        String octal = Converter.convert("5", Notations.DECIMAL, Notations.OCTAL);
        assertEquals("5", octal);
    }
    @Test
    public void convert6FromDecimalToHex() {
        String hex = Converter.convert("6", Notations.DECIMAL, Notations.HEX);
        assertEquals("6", hex);
    }
    @Test
    public void convert7FromHexBinary() {
        String hex = "7";
        String binary = Converter.convert(hex, Notations.HEX, Notations.BINARY);
        assertEquals("111", binary);
    }
    @Test
    public void convert14aFromHexToBinary() {
        String hex = "14a";
        String binary = Converter.convert(hex, Notations.HEX, Notations.BINARY);
        assertEquals("101001010", binary);
    }
    @Test
    public void convert13f40FromHexToBinary() {
        String hex = "13f40";
        String binary = Converter.convert(hex, Notations.HEX, Notations.BINARY);
        assertEquals("10011111101000000", binary);
    }
    @Test
    public void convert8FromHexToOctal() {
        String hex = "8";
        String octal = Converter.convert(hex, Notations.HEX, Notations.OCTAL);
        assertEquals("10", octal);
    }
    @Test
    public void convert14aFromHexToOctal() {
        String hex = "14a";
        String octal = Converter.convert(hex, Notations.HEX, Notations.OCTAL);
        assertEquals("512", octal);
    }
    @Test
    public void convert19FromHexToOctal() {
        String hex = "19";
        String octal = Converter.convert(hex, Notations.HEX, Notations.OCTAL);
        assertEquals("31", octal);
    }
    @Test
    public void converter1bFromHexToHex() {
        String hex = "1b";
        String decimal = Converter.convert(hex, Notations.HEX, Notations.HEX);
        assertEquals("1b", decimal);
    }
    @Test
    public void converter19FromDecimalToDecimal() {
        String decimal = "19";
        String decimal2 = Converter.convert(decimal, Notations.DECIMAL, Notations.DECIMAL);
        assertEquals("19", decimal2);
    }
    @Test
    public void converter23FromOctalToOctal() {
        String octal = "23";
        String octal2 = Converter.convert(octal, Notations.OCTAL, Notations.OCTAL);
        assertEquals("23", octal2);
    }
    @Test
    public void converter1bFromHexToDecimal() {
        String hex = "1b";
        String hex2 = Converter.convert(hex, Notations.HEX, Notations.DECIMAL);
        assertEquals("27", hex2);
    }
    @Test
    public void converter10FromBinaryToBinary() {
        String binary = "10";
        String binary2 = Converter.convert(binary, Notations.BINARY, Notations.BINARY);
        assertEquals("10", binary2);
    }

}
