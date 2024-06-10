package com.testevr.controller;

import com.testevr.dao.GenericDao;
import com.testevr.dao.ItemPedidoDao;
import com.testevr.model.ItemPedidoModel;
import java.util.List;

/**
 * @author Diego Barbosa
 */
public class ItemPedidoController {

    private GenericDao<ItemPedidoModel> ItemPedidoDao = new GenericDao<>(ItemPedidoModel.class);
    private ItemPedidoDao itemPedidoClasse = new ItemPedidoDao();

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

    public boolean produtoPossuiPedidos(Long id) {
        return this.itemPedidoClasse.produtoPossuiPedidos(id);
    }

}
