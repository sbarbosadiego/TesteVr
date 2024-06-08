package com.testevr.model;

import com.testevr.exception.ClienteException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
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
    public void testSetNomeCliente_ValidName() {
        String nome = "Cliente Válido";
        cliente.setNomeCliente(nome);
        assertEquals(nome, cliente.getNomeCliente());
    }

    @Test(expected = ClienteException.class)
    public void testSetNomeCliente_NameTooLong() {
        String nome = "A".repeat(101); // Nome com 101 caracteres
        cliente.setNomeCliente(nome);
    }

    @Test(expected = ClienteException.class)
    public void testSetNomeCliente_EmptyName() {
        cliente.setNomeCliente("");
    }

    @Test
    public void testSetLimiteCompra_ValidLimit() {
        Double limite = 1000.0;
        cliente.setLimiteCompra(limite);
        assertEquals(limite, cliente.getLimiteCompra());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetLimiteCompra_NegativeLimit() {
        cliente.setLimiteCompra(-500.0);
    }

    @Test
    public void testSetDiaFechamento_ValidDay() {
        cliente.setDiaFechamento(15);
        assertEquals(15, cliente.getDiaFechamentoFatura());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetDiaFechamento_InvalidDay_LessThan1() {
        cliente.setDiaFechamento(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetDiaFechamento_InvalidDay_GreaterThan31() {
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
