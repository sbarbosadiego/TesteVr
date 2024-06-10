package com.testevr.model;

import com.testevr.exception.ClienteException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Diego Barbosa
 */
public class ClienteModelTest {

    private ClienteModel cliente;

    @Before
    public void setUp() {
        cliente = new ClienteModel();
    }

    @Test
    public void testSetNomeClienteNomeValido() {
        String nome = "Cliente Válido";
        cliente.setNomeCliente(nome);
        assertEquals(nome, cliente.getNomeCliente());
    }

    @Test(expected = ClienteException.class)
    public void testSetNomeClienteNomeExtenso() {
        String nome = "A".repeat(101);
        cliente.setNomeCliente(nome);
    }

    @Test(expected = ClienteException.class)
    public void testSetNomeClienteNomeVazio() {
        cliente.setNomeCliente("");
    }

    @Test
    public void testSetLimiteCompraLimiteValido() {
        Double limite = 1000.0;
        cliente.setLimiteCompra(limite);
        assertEquals(limite, cliente.getLimiteCompra());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetLimiteCompraValorNegativo() {
        cliente.setLimiteCompra(-500.0);
    }

    @Test
    public void testSetDiaFechamentoDiaValido() {
        cliente.setDiaFechamento(15);
        assertEquals(15, cliente.getDiaFechamentoFatura());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetDiaFechamentoDiaInvalidoMenor() {
        cliente.setDiaFechamento(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetDiaFechamentoDiaInvalidoMaior() {
        cliente.setDiaFechamento(32);
    }

    @Test
    public void testCodigoCliente() {
        cliente.setCodigoCliente(1L);
        assertEquals(Long.valueOf(1), cliente.getCodigoCliente());
    }

    @Test
    public void testPedidos() {
        List<PedidoModel> pedidos = new ArrayList<>();
        cliente.setPedidos(pedidos);
        assertEquals(pedidos, cliente.getPedidos());
    }

}
