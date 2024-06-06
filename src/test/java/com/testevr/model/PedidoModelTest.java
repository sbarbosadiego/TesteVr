package com.testevr.model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * @author Diego Barbosa
 */
public class PedidoModelTest {
    
    @Test
    public void testSetValorPedidoValido() {
        PedidoModel pedido = new PedidoModel();
        pedido.setValorPedido(100.0);
        assertEquals(100.0, pedido.getValorPedido(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetValorPedidoNegativo() {
        PedidoModel pedido = new PedidoModel();
        pedido.setValorPedido(-50.0);
    }
    
}
