package com.testevr.util;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * @author Diego Barbosa
 */
public class FormatarValor {

    public static Double formatarStringDouble(String texto) {
        double valorFormatado = 0.0;
        try {
            NumberFormat format = NumberFormat.getInstance(new Locale("pt", "BR"));
            texto = texto.replaceAll("[^0-9,\\.]", "");
            if (texto.isEmpty()) {
                throw new NumberFormatException("O valor digitado não é válido");
            }
            Number number = format.parse(texto);
            valorFormatado = number.doubleValue();
            return valorFormatado;
        } catch (ParseException e) {
            throw new NumberFormatException("O valor digitado não é válido");
        }
    }

}
