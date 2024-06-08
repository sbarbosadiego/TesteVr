package com.testevr.dao;

import com.testevr.model.PedidoModel;
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

}
