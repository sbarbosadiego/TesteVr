package com.testevr.util;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * @author Diego Barbosa
 */
public class FormatarValorTest {
    
    @Test
    public void testFormatarStringDouble_ValidInput() {
        String input = "R$ 7.749,51";
        double expected = 7749.51;
        double result = FormatarValor.formatarStringDouble(input);
        assertEquals(expected, result, 0.0001);
    }
    
    @Test
    public void testFormatarStringDouble_ValidInputNoCurrencySymbol() {
        String input = "7.749,51";
        double expected = 7749.51;
        double result = FormatarValor.formatarStringDouble(input);
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void testFormatarStringDouble_ValidInputWithSpaces() {
        String input = "  7.749,51  ";
        double expected = 7749.51;
        double result = FormatarValor.formatarStringDouble(input);
        assertEquals(expected, result, 0.0001);
    }

    @Test
    public void testFormatarStringDouble_SingleDigit() {
        String input = "7,0";
        double expected = 7.0;
        double result = FormatarValor.formatarStringDouble(input);
        assertEquals(expected, result, 0.0001);
    }

    @Test(expected = NumberFormatException.class)
    public void testFormatarStringDouble_InvalidInput() {
        String input = "invalid";
        FormatarValor.formatarStringDouble(input);
    }
    
}
