package com.testevr.dao;

import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author Diego Barbosa
 */
public class GenericDao<T> extends Conexao {

    private final Class<T> classe;

    public GenericDao(Class<T> classe) {
        this.classe = classe;
    }

    public int salvar(T classe) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(classe);
            entityManager.getTransaction().commit();
            return 1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 0;
        }
    }

    public boolean atualizar(T classe) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(classe);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    public boolean excluir(Long id) {
        T entity = null;
        try {
            entityManager.getTransaction().begin();
            entity = entityManager.find(classe, id);
            if (entity != null) {
                entityManager.remove(entity);
            }
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    /**
     * Realiza a consulta ao banco de dados e retorna um único registro.
     * @param id
     * @return entity
     */
    public T retornar(Long id) {
        T entity = null;
        try {
            entityManager.getTransaction().begin();
            entity = entityManager.find(classe, id);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return entity;
    }
    
    /**
     * Retorna uma lista com todos os registros da tabela.
     * @return 
     */
    public List<T> retornarLista() {
        String jpql = "SELECT t FROM " + classe.getName() + " t";
        TypedQuery<T> query = entityManager.createQuery(jpql, classe);
        try {
            List<T> lista = query.getResultList();
            return lista;
        } catch (PersistenceException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
    
}
