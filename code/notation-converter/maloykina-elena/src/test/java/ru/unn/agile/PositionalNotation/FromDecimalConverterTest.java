package ru.unn.agile.PositionalNotation;

import static org.junit.Assert.*;
import org.junit.Test;

public class FromDecimalConverterTest {
    @Test
    public void convert0ToBinary() {
        String binary = FromDecimalConverter.convertToBinary(0);
        assertEquals("0", binary);
    }
    @Test
    public void convert10ToBinary() {
        String binary = FromDecimalConverter.convertToBinary(10);
        assertEquals("1010", binary);
    }
    @Test
    public void convert19ToBinary() {
        String binary = FromDecimalConverter.convertToBinary(19);
        assertEquals("10011", binary);
    }
    @Test
    public void convert0ToOctal() {
        String octal = FromDecimalConverter.convertToOctal(0);
        assertEquals("0", octal);
    }
    @Test
    public void convert7ToOctal() {
        String octal = FromDecimalConverter.convertToOctal(6);
        assertEquals("6", octal);
    }
    @Test
    public void convert9ToOctal() {
        String octal = FromDecimalConverter.convertToOctal(9);
        assertEquals("11", octal);
    }
    @Test
    public void convert26ToOctal() {
        String octal = FromDecimalConverter.convertToOctal(26);
        assertEquals("32", octal);
    }
    @Test
    public void convert0ToHex() {
        String hex = FromDecimalConverter.convertToHex(0);
        assertEquals("0", hex);
    }
    @Test
    public void convert13ToHex() {
        String hex = FromDecimalConverter.convertToHex(13);
        assertEquals("d", hex);
    }
    @Test
    public void convert59ToHex() {
        String hex = FromDecimalConverter.convertToHex(59);
        assertEquals("3b", hex);
    }
}
