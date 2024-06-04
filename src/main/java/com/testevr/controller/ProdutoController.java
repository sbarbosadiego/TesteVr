package com.testevr.controller;

import com.testevr.dao.GenericDao;
import com.testevr.dao.ProdutoDao;
import com.testevr.model.ProdutoModel;
import java.util.List;

/**
 * @author Diego Barbosa
 */
public class ProdutoController {
    
    GenericDao<ProdutoModel> produtoDao = new GenericDao<>(ProdutoModel.class);
    private ProdutoDao produtoDaoClasse = new ProdutoDao();
    
    public int salvarProdutoController(ProdutoModel produto) {
        return this.produtoDao.salvar(produto);
    }
    
    public boolean atualizarProdutoController(ProdutoModel produto) {
        return this.produtoDao.atualizar(produto);
    }
    
    public boolean excluirProdutoController(Long id) {
        return this.produtoDao.excluir(id);
    }
    
    public ProdutoModel retornarAlunoController(Long id) {
        return this.produtoDao.retornar(id);
    }
    
    public ProdutoModel retornarProdutoNomeController(String nome) {
        return this.produtoDaoClasse.retornarProdutoNome(nome);
    }
    
    public List<ProdutoModel> retornarListaProdutosController() {
        return this.produtoDao.retornarLista();
    }
    
    public List<ProdutoModel> retornarListaProdutoController(String nome) {
        return this.produtoDaoClasse.retornarListaProdutoNome(nome);
    }
}
