package com.testevr.dao;

import com.testevr.model.PedidoModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author Diego Barbosa
 */
public class PedidoDao extends GenericDao<PedidoModel> {

    public PedidoDao() {
        super(PedidoModel.class);
    }

    public List<PedidoModel> retornarListaPedidoNome(String cliente) {
        EntityManager entityManager = getEntityManager();
        try {
            List<PedidoModel> listaPedidos = entityManager
                    .createQuery("SELECT u FROM pedidos u WHERE u.cliente.nomeCliente LIKE :nome", PedidoModel.class)
                    .setParameter("nome", "%" + cliente + "%")
                    .getResultList();
            return listaPedidos;
        } catch (NoResultException | NonUniqueResultException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível retornar resultado para consulta");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }

    public boolean clientePossuiPedidos(Long clienteId) {
        EntityManager entityManager = getEntityManager();
        try {
            List<PedidoModel> pedidos = entityManager
                    .createQuery("SELECT p FROM pedidos p WHERE p.cliente.id = :clienteId", PedidoModel.class)
                    .setParameter("clienteId", clienteId)
                    .getResultList();
            return !pedidos.isEmpty();
        } catch (NoResultException e) {
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
