package com.testevr.controller;

import com.testevr.dao.GenericDao;
import com.testevr.model.PedidoModel;
import java.util.List;

/**
 * @author Diego Barbosa
 */
public class PedidoController {

    private GenericDao<PedidoModel> pedidoDao = new GenericDao<>(PedidoModel.class);

    public int salvarPedidoController(PedidoModel pedido) {
        return this.pedidoDao.salvar(pedido);
    }

    public boolean atualizarPedidoController(PedidoModel pedido) {
        return this.pedidoDao.atualizar(pedido);
    }

    public boolean excluirPedidoController(Long id) {
        return this.pedidoDao.excluir(id);
    }

    public PedidoModel retornarPedidoController(Long id) {
        return this.pedidoDao.retornar(id);
    }

    public List<PedidoModel> retornarListaPedidosController() {
        return this.pedidoDao.retornarLista();
    }

}
