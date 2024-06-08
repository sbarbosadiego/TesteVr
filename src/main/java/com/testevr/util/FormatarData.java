package com.testevr.util;

import java.time.DateTimeException;
import java.time.LocalDate;

/**
 * @author Diego Barbosa
 */
public class FormatarData {

    public static LocalDate formatarDataLocalDate(String data) {
        int diaFormatado;
        int mesFormatado;
        int anoFormatado;
        if (data == null || data.length() < 10) {
            return null;
        }
        try {
            String dia = data.substring(0, 2);
            String mes = data.substring(3, 5);
            String ano = data.substring(6, 10);
            diaFormatado = Integer.parseInt(dia);
            mesFormatado = Integer.parseInt(mes);
            anoFormatado = Integer.parseInt(ano);
            return LocalDate.of(anoFormatado, mesFormatado, diaFormatado);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("A data informada não é válida");
        } catch (DateTimeException e) {
            throw new DateTimeException("Data inválida");
        }
    }

    public static String formatarDataTexto(LocalDate data) {
        String dataTexto;
        if (data == null) {
            throw new IllegalArgumentException("A data não pode ser vazia");
        }
        try {
            dataTexto = data.toString();
            if (dataTexto == null || dataTexto.length() < 10) {
                throw new DateTimeException("Formato de data inválido");
            }
            String ano = dataTexto.substring(0, 4);
            String mes = dataTexto.substring(5, 7);
            String dia = dataTexto.substring(8, 10);
            dataTexto = dia + "/" + mes + "/" + ano;
            return dataTexto;
        } catch (DateTimeException e) {
            throw new DateTimeException("Data inválida");
        }
    }
    
    public static String formatarDataTabela(String data) {
        String dataTexto;
        if (data == null) {
            throw new IllegalArgumentException("A data não pode ser vazia");
        }
        try {
            dataTexto = data.toString();
            if (dataTexto == null || dataTexto.length() < 10) {
                throw new DateTimeException("Formato de data inválido");
            }
            String ano = dataTexto.substring(0, 4);
            String mes = dataTexto.substring(5, 7);
            String dia = dataTexto.substring(8, 10);
            dataTexto = dia + "/" + mes + "/" + ano;
            return dataTexto;
        } catch (DateTimeException e) {
            throw new DateTimeException("Data inválida");
        }
    }

}
