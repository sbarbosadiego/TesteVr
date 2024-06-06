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
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 * @author Diego Barbosa
 */
@Data
@Entity
@Table(name = "pedidos")
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
    
    public PedidoModel(){
        this.valorPedido = 0.0;
    }

    public void setValorPedido(Double valorPedido) {
        if (valorPedido < 0) {
            throw new IllegalArgumentException("O valor do pedido não pode ser negativo!");
        }
        this.valorPedido = valorPedido;
    }
    
    public void adicionarItem(ItemPedidoModel item) {
        item.setPedido(this);
        //this.valorPedido += item.getValorTotal();
        this.listaItens.add(item);
    }
    
    public void removerItem(int index){
        ItemPedidoModel lista = this.listaItens.get(index);
        this.listaItens.remove(index);
    }

}
