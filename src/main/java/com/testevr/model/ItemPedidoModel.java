package com.testevr.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import lombok.Data;

/**
 * @author Diego Barbosa
 */
@Data
@Entity(name = "item_pedido")
public class ItemPedidoModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_codigo_item_pedido")
    Long codigoItemPedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_pedido", referencedColumnName = "pk_codigo_pedido", nullable = false)
    PedidoModel pedido;

    @ManyToOne
    @JoinColumn(name = "fk_produto", referencedColumnName = "pk_codigo_produto", nullable = false)
    ProdutoModel produto;

    @Column(name = "item_quantidade", nullable = false)
    Double quantidade;

    @Column(name = "valor_unitario", nullable = false)
    Double valorUnitario;

    @Column(name = "valor_total", nullable = false)
    Double valorTotal;

    public void setQuantidade(Double quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("O valor do pedido não pode ser negativo!");
        }
        this.quantidade = quantidade;
    }

    public void setValorUnitario(Double valorUnitario) {
        if (valorUnitario < 0) {
            throw new IllegalArgumentException("O valor unitário não pode ser negativo!");
        }
        this.valorUnitario = valorUnitario;
    }

    public void setValorTotal(Double valorTotal) {
        if (valorTotal < 0) {
            throw new IllegalArgumentException("O valor do pedido não pode ser negativo!");
        }
        this.valorTotal = valorTotal;
    }

}
