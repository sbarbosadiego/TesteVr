package com.testevr.controller;

import com.testevr.dao.ClienteDao;
import com.testevr.dao.GenericDao;
import com.testevr.model.ClienteModel;
import java.util.List;

/**
 * @author Diego Barbosa
 */
public class ClienteController {

    private GenericDao<ClienteModel> clienteDao = new GenericDao<>(ClienteModel.class);
    private ClienteDao clienteDaoClasse = new ClienteDao();

    public int salvarClienteController(ClienteModel cliente) {
        return this.clienteDao.salvar(cliente);
    }

    public boolean atualizarClienteController(ClienteModel cliente) {
        return this.clienteDao.atualizar(cliente);
    }

    public boolean excluirClienteController(Long id) {
        return this.clienteDao.excluir(id);
    }

    public ClienteModel retornarClienteController(Long id) {
        return this.clienteDao.retornar(id);
    }

    public ClienteModel retornarClienteNomeController(String nome) {
        return this.clienteDaoClasse.retornarClienteNome(nome);
    }

    public List<ClienteModel> retornarListaClientesController() {
        return this.clienteDao.retornarLista();
    }

    public List<ClienteModel> retornarListaClienteNomeController(String nome) {
        return this.clienteDaoClasse.retornarListaClienteNome(nome);
    }

}
