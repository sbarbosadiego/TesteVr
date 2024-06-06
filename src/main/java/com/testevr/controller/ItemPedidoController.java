package com.testevr.controller;

import com.testevr.dao.GenericDao;
import com.testevr.model.ItemPedidoModel;
import java.util.List;

/**
 * @author Diego Barbosa
 */
public class ItemPedidoController {
    
    private GenericDao<ItemPedidoModel> ItemPedidoDao = new GenericDao<>(ItemPedidoModel.class);
    
    public int salvarItemPedidoController(ItemPedidoModel itemPedido) {
        return this.ItemPedidoDao.salvar(itemPedido);
    }
    
    public boolean atualizarItemPedidoController(ItemPedidoModel itemPedido) {
        return this.ItemPedidoDao.atualizar(itemPedido);
    }
    
    public boolean excluirItemPedidoController(Long id) {
        return this.ItemPedidoDao.excluir(id);
    }
    
    public ItemPedidoModel retornarItemPedidoController(Long id) {
        return this.ItemPedidoDao.retornar(id);
    }
    
    public List<ItemPedidoModel> retornarListaItemPedidosController() {
        return this.ItemPedidoDao.retornarLista();
    }
    
}
