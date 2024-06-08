package com.testevr.services;

import com.testevr.model.ClienteModel;
import com.testevr.model.PedidoModel;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Diego Barbosa
 */
public class ValidadorCredito {
    
    public void validarCredito(ClienteModel cliente, Double pedidoAtual){
        int dataFechamento = cliente.getDiaFechamentoFatura();
        LocalDate dataAtual = LocalDate.now();
        double limiteCredito = cliente.getLimiteCompra();
        double totalPedidos = 0.0;
        /*
        for (PedidoModel pedido : cliente.getPedidos()) {
            LocalDateTime dataPedido = pedido.getDataPedido();
            if (dataPedido.toLocalDate().isAfter(dataFechamento)) {
                totalPedidos += pedido.getValorPedido();
            }
        }
        */
        System.out.println("Total pedidos: " + totalPedidos);
        if (totalPedidos + pedidoAtual > limiteCredito) {
            double creditoDisponivel = limiteCredito - totalPedidos;
            double creditoAtual = limiteCredito - (totalPedidos + pedidoAtual);
            System.out.println("Cliente " + cliente.getNomeCliente() + " ultrapassou o limite de crédito.");
            System.out.println("Limite disponível: " + creditoDisponivel);
            System.out.println("Data de fechamento da fatura: " + cliente.getDiaFechamentoFatura());
        } else {
            System.out.println("Cliente " + cliente.getNomeCliente() + " está dentro do limite de crédito.");
        }
    }
    
}
