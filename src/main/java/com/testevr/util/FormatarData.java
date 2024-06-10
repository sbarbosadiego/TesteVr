package com.testevr.util;

import java.time.DateTimeException;
import java.time.LocalDate;

/**
 * @author Diego Barbosa
 */
public class FormatarData {

    /**
     * Formata String para LocalDate com formato yyyy/MM/dd
     *
     * @param data
     * @return LocalDate
     */
    public static LocalDate formatarDataLocalDate(String data) {
        if (data == null || data.length() < 10) {
            throw new IllegalArgumentException("A data informada não é válida");
        }
        try {
            String dia = data.substring(0, 2);
            String mes = data.substring(3, 5);
            String ano = data.substring(6, 10);
            int diaFormatado = Integer.parseInt(dia);
            int mesFormatado = Integer.parseInt(mes);
            int anoFormatado = Integer.parseInt(ano);
            return LocalDate.of(anoFormatado, mesFormatado, diaFormatado);
        } catch (NumberFormatException | DateTimeException e) {
            throw new IllegalArgumentException("A data informada não é válida", e);
        }
    }

    /**
     * Formata LocalDate para uma String em data no formato dd/MM/yyyy
     *
     * @param data
     * @return String
     */
    public static String formatarDataTexto(LocalDate data) {
        if (data == null) {
            throw new IllegalArgumentException("A data não pode ser vazia");
        }
        try {
            String ano = String.format("%04d", data.getYear());
            String mes = String.format("%02d", data.getMonthValue());
            String dia = String.format("%02d", data.getDayOfMonth());
            return dia + "/" + mes + "/" + ano;
        } catch (DateTimeException e) {
            throw new IllegalArgumentException("Data inválida", e);
        }
    }

    /**
     * Formata uma String no formato yyyy/MM/dd para uma String dd/MM/yyyy
     *
     * @param data
     * @return String
     */
    public static String formatarDataTabela(String data) {
        if (data == null || data.length() < 10) {
            throw new IllegalArgumentException("A data não pode ser vazia");
        }
        try {
            String ano = data.substring(0, 4);
            String mes = data.substring(5, 7);
            String dia = data.substring(8, 10);
            return dia + "/" + mes + "/" + ano;
        } catch (DateTimeException e) {
            throw new IllegalArgumentException("Data inválida", e);
        }
    }

}
