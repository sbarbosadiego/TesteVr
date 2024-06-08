package com.testevr.model;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Diego Barbosa
 */
public class ItemPedidoModelTest {
    
    private ItemPedidoModel itemPedido;

    @Before
    public void setUp() {
        itemPedido = new ItemPedidoModel();
    }

    @Test
    public void testSetQuantidade_ValidQuantity() {
        Double quantidade = 10.0;
        itemPedido.setQuantidade(quantidade);
        assertEquals(quantidade, itemPedido.getQuantidade());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetQuantidade_NegativeQuantity() {
        itemPedido.setQuantidade(-1.0);
    }

    @Test
    public void testSetValorUnitario_ValidUnitValue() {
        Double valorUnitario = 50.0;
        itemPedido.setValorUnitario(valorUnitario);
        assertEquals(valorUnitario, itemPedido.getValorUnitario());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetValorUnitario_NegativeUnitValue() {
        itemPedido.setValorUnitario(-50.0);
    }

    @Test
    public void testSetValorTotal_ValidTotalValue() {
        Double valorTotal = 500.0;
        itemPedido.setValorTotal(valorTotal);
        assertEquals(valorTotal, itemPedido.getValorTotal());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetValorTotal_NegativeTotalValue() {
        itemPedido.setValorTotal(-500.0);
    }

    @Test
    public void testCodigoItemPedido() {
        itemPedido.setCodigoItemPedido(1L);
        assertEquals(Long.valueOf(1), itemPedido.getCodigoItemPedido());
    }

    @Test
    public void testPedido() {
        PedidoModel pedido = new PedidoModel();
        itemPedido.setPedido(pedido);
        assertEquals(pedido, itemPedido.getPedido());
    }

    @Test
    public void testProduto() {
        ProdutoModel produto = new ProdutoModel();
        itemPedido.setProduto(produto);
        assertEquals(produto, itemPedido.getProduto());
    }
    
}
