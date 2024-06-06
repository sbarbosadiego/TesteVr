package com.testevr.model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * @author Diego Barbosa
 */
public class ItemPedidoModelTest {
    
    @Test
    public void testSetQuantidadeValida() {
        ItemPedidoModel itemPedido = new ItemPedidoModel();
        itemPedido.setQuantidade(5.0);
        assertEquals(5.0, itemPedido.getQuantidade(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetQuantidadeNegativa() {
        ItemPedidoModel itemPedido = new ItemPedidoModel();
        itemPedido.setQuantidade(-2.0);
    }

    @Test
    public void testSetValorUnitarioValido() {
        ItemPedidoModel itemPedido = new ItemPedidoModel();
        itemPedido.setValorUnitario(10.0);
        assertEquals(10.0, itemPedido.getValorUnitario(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetValorUnitarioNegativo() {
        ItemPedidoModel itemPedido = new ItemPedidoModel();
        itemPedido.setValorUnitario(-5.0);
    }

    @Test
    public void testSetValorTotalValido() {
        ItemPedidoModel itemPedido = new ItemPedidoModel();
        itemPedido.setValorTotal(50.0);
        assertEquals(50.0, itemPedido.getValorTotal(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetValorTotalNegativo() {
        ItemPedidoModel itemPedido = new ItemPedidoModel();
        itemPedido.setValorTotal(-30.0);
    }
    
}
