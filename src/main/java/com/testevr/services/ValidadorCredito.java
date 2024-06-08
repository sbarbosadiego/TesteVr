package com.testevr.services;

import com.testevr.model.ClienteModel;
import com.testevr.model.PedidoModel;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 * @author Diego Barbosa
 */
public class ValidadorCredito {

    Locale localeBR = new Locale("pt", "BR");
    NumberFormat valorReal = NumberFormat.getCurrencyInstance(localeBR);

    public boolean validarCredito(ClienteModel cliente, Double pedidoAtual) {
        int diaFechamento = cliente.getDiaFechamentoFatura();
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataFechamento = ajustarDataFechamento(diaFechamento, dataAtual);
        double limiteCredito = cliente.getLimiteCompra();
        double totalPedidos = 0.0;

        for (PedidoModel pedido : cliente.getPedidos()) {
            LocalDateTime dataPedido = pedido.getDataPedido();
            if (dataPedido.toLocalDate().isAfter(dataFechamento)) {
                totalPedidos += pedido.getValorPedido();
            }
        }

        if (totalPedidos + pedidoAtual > limiteCredito) {
            double creditoAtual = limiteCredito - (totalPedidos + pedidoAtual);
            JOptionPane.showMessageDialog(null, "Cliente " + cliente.getNomeCliente() + " ultrapassou o limite de crédito.\n"
                    + "Limite disponível: " + valorReal.format(creditoAtual) + "\n"
                    + "Data de fechamento da fatura: " + cliente.getDiaFechamentoFatura(), "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            return true;
        } else {
            double creditoAtual = limiteCredito - (totalPedidos + pedidoAtual);
            System.out.println("Crédito atual: " + creditoAtual);
            System.out.println("Cliente " + cliente.getNomeCliente() + " está dentro do limite de crédito.");
            JOptionPane.showMessageDialog(null, "Limite Disponível: " + valorReal.format(creditoAtual), "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    protected LocalDate ajustarDataFechamento(int diaFechamento, LocalDate dataAtual) {
        int ultimoDiaMesAtual = dataAtual.lengthOfMonth();
        if (diaFechamento > ultimoDiaMesAtual) {
            diaFechamento = ultimoDiaMesAtual;
        }
        return dataAtual.withDayOfMonth(diaFechamento).minusMonths(1);
    }

}
