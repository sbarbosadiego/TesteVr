package com.testevr.dao;

import com.testevr.model.ProdutoModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author Diego Barbosa
 */
public class ProdutoDao extends GenericDao<ProdutoModel> {

    public ProdutoDao() {
        super(ProdutoModel.class);
    }

    public List<ProdutoModel> retornarListaProdutoNome(String produto) {
        EntityManager entityManager = getEntityManager();
        try {
            List<ProdutoModel> listaProdutos = entityManager
                    .createQuery("SELECT u FROM produtos u WHERE u.descricaoProduto LIKE :nome", ProdutoModel.class)
                    .setParameter("nome", "%" + produto + "%")
                    .getResultList();
            return listaProdutos;
        } catch (NoResultException | NonUniqueResultException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível retornar resultado para consulta");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }

    public ProdutoModel retornarProdutoNome(String produto) {
        EntityManager entityManager = getEntityManager();
        ProdutoModel produtoModel = new ProdutoModel();
        try {
            produtoModel = entityManager
                    .createQuery("SELECT u FROM produtos u WHERE u.descricaoProduto LIKE :nome", ProdutoModel.class)
                    .setParameter("nome", "%" + produto + "%")
                    .setMaxResults(1)
                    .getSingleResult();
            return produtoModel;
        } catch (NoResultException | NonUniqueResultException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível localizar resultado para consulta");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }

}
