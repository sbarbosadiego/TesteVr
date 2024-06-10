package com.testevr.services;

import com.testevr.model.ClienteModel;
import com.testevr.model.PedidoModel;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Diego Barbosa
 */
public class ValidadorCreditoTest {

    private ValidadorCredito validadorCredito;

    @Before
    public void setUp() {
        validadorCredito = new ValidadorCredito();
    }

    @Test
    public void testValidarCreditoDentroDoLimite() {
        ClienteModel cliente = criarCliente(1000.0, 5, criarPedidos(200.0, LocalDateTime.now().minusDays(1), 100.0, LocalDateTime.now().minusDays(2)));
        Double pedidoAtual = 300.0;

        boolean resultado = validadorCredito.validarCredito(cliente, pedidoAtual);

        assertFalse(resultado);
    }

    @Test
    public void testValidarCreditoForaDoLimite() {
        ClienteModel cliente = criarCliente(500.0, 5, criarPedidos(200.0, LocalDateTime.now().minusDays(1), 200.0, LocalDateTime.now().minusDays(2)));
        Double pedidoAtual = 200.0;

        boolean resultado = validadorCredito.validarCredito(cliente, pedidoAtual);

        assertTrue(resultado);
    }

    @Test
    public void testAjustarDataFechamento() {
        LocalDate dataAtual = LocalDate.of(2024, 6, 9);
        int diaFechamento = 5;

        LocalDate dataFechamento = validadorCredito.ajustarDataFechamento(diaFechamento, dataAtual);

        assertEquals(LocalDate.of(2024, 5, 5), dataFechamento);
    }

    private ClienteModel criarCliente(double limiteCompra, int diaFechamentoFatura, List<PedidoModel> pedidos) {
        ClienteModel cliente = new ClienteModel();
        cliente.setLimiteCompra(limiteCompra);
        cliente.setDiaFechamentoFatura(diaFechamentoFatura);
        cliente.setPedidos(pedidos);
        cliente.setNomeCliente("Cliente Teste");
        return cliente;
    }

    private List<PedidoModel> criarPedidos(Object... valoresEDataPedidos) {
        List<PedidoModel> pedidos = new ArrayList<>();
        for (int i = 0; i < valoresEDataPedidos.length; i += 2) {
            PedidoModel pedido = new PedidoModel();
            pedido.setValorPedido((Double) valoresEDataPedidos[i]);
            pedido.setDataPedido((LocalDateTime) valoresEDataPedidos[i + 1]);
            pedidos.add(pedido);
        }
        return pedidos;
    }

}
