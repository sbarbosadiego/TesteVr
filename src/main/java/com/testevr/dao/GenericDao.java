package com.testevr.dao;

import jakarta.persistence.EntityManager;
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

    public int salvar(T entity) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
            return 1;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Erro ao salvar registro: " + e.getMessage());
            return 0;
        } finally {
            entityManager.close();
        }
    }

    public boolean atualizar(T entity) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Erro ao atualizar registro: " + e.getMessage());
            return false;
        } finally {
            entityManager.close();
        }
    }

    public boolean excluir(Long id) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            T entity = entityManager.find(classe, id);
            if (entity != null) {
                entityManager.remove(entity);
                entityManager.getTransaction().commit();
                return true;
            } else {
                entityManager.getTransaction().rollback();
                JOptionPane.showMessageDialog(null, "Registro não encontrado para exclusão. ID: " + id);
                return false;
            }
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Erro ao excluir registro: " + e.getMessage());
            return false;
        } finally {
            entityManager.close();
        }
    }

    public T retornar(Long id) {
        EntityManager entityManager = getEntityManager();
        try {
            T entity = entityManager.find(classe, id);
            // Carrega a coleção associada para evitar LazyInitializationException
            if (entity != null) {
                entityManager.getTransaction().begin();
                entityManager.refresh(entity); // Carrega todas as coleções preguiçosas
                entityManager.getTransaction().commit();
            }
            return entity;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao retornar registro: " + e.getMessage());
            return null;
        } finally {
            entityManager.close();
        }
    }

    public List<T> retornarLista() {
        EntityManager entityManager = getEntityManager();
        String jpql = "SELECT t FROM " + classe.getName() + " t";
        TypedQuery<T> query = entityManager.createQuery(jpql, classe);
        try {
            return query.getResultList();
        } catch (PersistenceException e) {
            JOptionPane.showMessageDialog(null, "Erro ao retornar consulta: " + e.getMessage());
            return Collections.emptyList();
        } finally {
            entityManager.close();
        }
    }

}
