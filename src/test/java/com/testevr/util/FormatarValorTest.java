package com.testevr.util;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * @author Diego Barbosa
 */
public class FormatarValorTest {

    @Test(expected = NumberFormatException.class)
    public void testFormatarStringDouble_InvalidInput() {
        String input = "invalid";
        FormatarValor.formatarStringDouble(input);
    }

    @Test
    public void testFormatarStringDouble_ValidInput() {
        String input = "1234,56";
        Double expected = 1234.56;
        Double actual = FormatarValor.formatarStringDouble(input);
        assertEquals(expected, actual);
    }

    @Test(expected = NumberFormatException.class)
    public void testFormatarStringDouble_EmptyInput() {
        String input = "";
        FormatarValor.formatarStringDouble(input);
    }

    @Test
    public void testFormatarStringDouble_ValidInputWithSpecialChars() {
        String input = "R$ 1.234,56";
        Double expected = 1234.56;
        Double actual = FormatarValor.formatarStringDouble(input);
        assertEquals(expected, actual);
    }

}
