package com.testevr.controller;

import com.testevr.dao.EstoqueDao;
import com.testevr.dao.GenericDao;
import com.testevr.model.EstoqueModel;
import java.util.List;

/**
 * @author Diego Barbosa
 */
public class EstoqueController {

    private GenericDao<EstoqueModel> estoqueDao = new GenericDao<>(EstoqueModel.class);
    private EstoqueDao estoqueDaoClasse = new EstoqueDao();

    public int salvarEstoqueController(EstoqueModel estoque) {
        return this.estoqueDao.salvar(estoque);
    }

    public boolean atualizarEstoqueController(EstoqueModel estoque) {
        return this.estoqueDao.atualizar(estoque);
    }

    public boolean excluirEstoqueController(Long id) {
        return this.estoqueDao.excluir(id);
    }

    public EstoqueModel retornarEstoqueController(Long id) {
        return this.estoqueDao.retornar(id);
    }

    /*
    public EstoqueModel retornarEstoqueNomeController(String nome) {
        return this.estoqueDaoClasse.retornarEstoqueNome(nome);
    }
    */
    
    public List<EstoqueModel> retornarListaEstoquesController() {
        return this.estoqueDao.retornarLista();
    }
    
    /*
    public List<EstoqueModel> retornarListaEstoqueController(String nome) {
        return this.estoqueDaoClasse.retornarListaEstoqueNome(nome);
    }
    */
    
}
