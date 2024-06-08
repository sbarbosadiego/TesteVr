package com.testevr.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 * @author Diego Barbosa
 */
@Data
@Entity(name = "pedidos")
public class PedidoModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_codigo_pedido")
    private Long codigoPedido;

    @ManyToOne
    @JoinColumn(name = "fk_cliente", referencedColumnName = "pk_codigo_cliente", nullable = false)
    private ClienteModel cliente;

    @Column(name = "valor_pedido", nullable = false)
    private Double valorPedido;

    @Column(name = "data_pedido", nullable = false)
    private LocalDateTime dataPedido;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
    List<ItemPedidoModel> listaItens = new ArrayList<>();

    public PedidoModel() {
        this.valorPedido = 0.0;
    }

    public void setValorPedido(Double valorPedido) {
        if (valorPedido < 0) {
            throw new IllegalArgumentException("O valor do pedido não pode ser negativo!");
        }
        this.valorPedido = valorPedido;
    }

    public void adicionarItem(ItemPedidoModel item) {
        item.setPedido(this); // Define a referência do pedido no item
        this.listaItens.add(item);
    }

    public void removerItem(int index) {
        this.listaItens.remove(index);
    }

    public void adicionarItens(List<ItemPedidoModel> itens) {
        for (ItemPedidoModel item : itens) {
            adicionarItem(item);
        }
    }

    public void atualizarValorPedido() {
        double total = 0.0;
        for (ItemPedidoModel item : listaItens) {
            total += item.getValorTotal();
        }
        this.valorPedido = total;
    }

}
