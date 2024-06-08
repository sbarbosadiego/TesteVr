package com.testevr.model;

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
public class PedidoModelTest {
    
    private PedidoModel pedido;

    @Before
    public void setUp() {
        pedido = new PedidoModel();
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setCliente(new ClienteModel());
    }

    @Test
    public void testSetValorPedido_ValidValue() {
        Double valorPedido = 1000.0;
        pedido.setValorPedido(valorPedido);
        assertEquals(valorPedido, pedido.getValorPedido());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetValorPedido_NegativeValue() {
        pedido.setValorPedido(-1000.0);
    }

    @Test
    public void testAdicionarItem() {
        ItemPedidoModel item = new ItemPedidoModel();
        item.setValorTotal(500.0);
        pedido.adicionarItem(item);
        assertTrue(pedido.getListaItens().contains(item));
        assertEquals(pedido, item.getPedido());
    }

    @Test
    public void testRemoverItem() {
        ItemPedidoModel item = new ItemPedidoModel();
        pedido.adicionarItem(item);
        pedido.removerItem(0);
        assertFalse(pedido.getListaItens().contains(item));
    }

    @Test
    public void testAdicionarItens() {
        List<ItemPedidoModel> itens = new ArrayList<>();
        ItemPedidoModel item1 = new ItemPedidoModel();
        ItemPedidoModel item2 = new ItemPedidoModel();
        itens.add(item1);
        itens.add(item2);
        
        pedido.adicionarItens(itens);
        assertTrue(pedido.getListaItens().containsAll(itens));
        assertEquals(pedido, item1.getPedido());
        assertEquals(pedido, item2.getPedido());
    }

    @Test
    public void testAtualizarValorPedido() {
        ItemPedidoModel item1 = new ItemPedidoModel();
        item1.setValorTotal(500.0);
        ItemPedidoModel item2 = new ItemPedidoModel();
        item2.setValorTotal(300.0);
        
        pedido.adicionarItem(item1);
        pedido.adicionarItem(item2);
        pedido.atualizarValorPedido();
        
        assertEquals(Double.valueOf(800.0), pedido.getValorPedido());
    }

    @Test
    public void testCodigoPedido() {
        pedido.setCodigoPedido(1L);
        assertEquals(Long.valueOf(1), pedido.getCodigoPedido());
    }

    @Test
    public void testDataPedido() {
        LocalDateTime now = LocalDateTime.now();
        pedido.setDataPedido(now);
        assertEquals(now, pedido.getDataPedido());
    }

    @Test
    public void testCliente() {
        ClienteModel cliente = new ClienteModel();
        pedido.setCliente(cliente);
        assertEquals(cliente, pedido.getCliente());
    }
    
}
