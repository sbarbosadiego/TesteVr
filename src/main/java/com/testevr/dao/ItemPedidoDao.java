package com.testevr.dao;

import com.testevr.model.ItemPedidoModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import java.util.List;

/**
 * @author Diego Barbosa
 */
public class ItemPedidoDao extends GenericDao<ItemPedidoModel> {

    public ItemPedidoDao() {
        super(ItemPedidoModel.class);
    }

    public boolean produtoPossuiPedidos(Long produtoId) {
        EntityManager entityManager = getEntityManager();
        try {
            List<ItemPedidoModel> pedidos = entityManager
                    .createQuery("SELECT ip FROM item_pedido ip WHERE ip.produto.id = :produtoId", ItemPedidoModel.class)
                    .setParameter("produtoId", produtoId)
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
