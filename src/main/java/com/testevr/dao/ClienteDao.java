package com.testevr.dao;

import com.testevr.model.ClienteModel;
import jakarta.persistence.EntityManager;
import java.util.List;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import javax.swing.JOptionPane;

/**
 * @author Diego Barbosa
 */
public class ClienteDao extends GenericDao<ClienteModel> {

    public ClienteDao() {
        super(ClienteModel.class);
    }

    public List<ClienteModel> retornarListaClienteNome(String nome) {
        EntityManager entityManager = getEntityManager();
        try {
            List<ClienteModel> listaClientes = entityManager
                    .createQuery("SELECT u FROM clientes u WHERE u.nomeCliente LIKE :nome", ClienteModel.class)
                    .setParameter("nome", "%" + nome + "%")
                    .getResultList();
            return listaClientes;
        } catch (NoResultException | NonUniqueResultException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível retornar resultado para consulta");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }

    public ClienteModel retornarClienteNome(String nome) {
        EntityManager entityManager = getEntityManager();
        ClienteModel clienteModel = new ClienteModel();
        try {
            clienteModel = entityManager
                    .createQuery("SELECT u FROM clientes u WHERE u.nomeCliente LIKE :nome", ClienteModel.class)
                    .setParameter("nome", "%" + nome + "%")
                    .setMaxResults(1)
                    .getSingleResult();
            return clienteModel;
        } catch (NoResultException | NonUniqueResultException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível localizar resultado para consulta");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }

}
