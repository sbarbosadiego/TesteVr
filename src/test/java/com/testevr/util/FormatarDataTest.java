package com.testevr.util;

import java.time.DateTimeException;
import java.time.LocalDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 * @author Diego Barbosa
 */
public class FormatarDataTest {

        @Test
    public void testFormatarDataDiaValid() {
        // Testando com uma data válida
        String data = "15/08/2023";
        LocalDate expectedDate = LocalDate.of(2023, 8, 15);
        LocalDate actualDate = FormatarData.formatarDataLocalDate(data);
        assertEquals(expectedDate, actualDate);
    }

    @Test
    public void testFormatarDataDiaInvalidFormat() {
        // Testando com uma data em formato inválido
        String data = "15-08-2023";
        try {
            FormatarData.formatarDataLocalDate(data);
            fail("Expected DateTimeException to be thrown");
        } catch (DateTimeException e) {
            assertEquals("Data inválida", e.getMessage());
        }
    }

    @Test
    public void testFormatarDataDiaNull() {
        // Testando com uma data nula
        LocalDate actualDate = FormatarData.formatarDataLocalDate(null);
        assertNull(actualDate);
    }

    @Test
    public void testFormatarDataDiaInvalidNumber() {
        // Testando com uma data inválida (números não correspondem a uma data real)
        String data = "32/13/2023";
        try {
            FormatarData.formatarDataLocalDate(data);
            fail("Expected DateTimeException to be thrown");
        } catch (DateTimeException e) {
            assertEquals("Data inválida", e.getMessage());
        }
    }

    @Test
    public void testFormatarDataTextoValid() {
        // Testando com uma data válida
        LocalDate data = LocalDate.of(2023, 8, 15);
        String expectedDate = "15/08/2023";
        String actualDate = FormatarData.formatarDataTexto(data);
        assertEquals(expectedDate, actualDate);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFormatarDataTextoNull() {
        // Testando com uma data nula
        FormatarData.formatarDataTexto(null);
    }

    @Test
    public void testFormatarDataTextoInvalidFormat() {
        // Testando com uma data em formato inválido
        LocalDate data = LocalDate.of(2023, 8, 5);
        String expectedDate = "05/08/2023";
        String actualDate = FormatarData.formatarDataTexto(data);
        assertEquals(expectedDate, actualDate);
    }
}
