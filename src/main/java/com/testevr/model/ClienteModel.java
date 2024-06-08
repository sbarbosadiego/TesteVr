package com.testevr.model;

import com.testevr.exception.ClienteException;
import jakarta.persistence.CascadeType;
import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Diego Barbosa
 */
@Data
@NoArgsConstructor
@Entity(name = "clientes")
public class ClienteModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_codigo_cliente")
    private Long codigoCliente;

    @Column(name = "nome_cliente", length = 101, nullable = false)
    private String nomeCliente;

    @Column(name = "limite_compra", nullable = false)
    private Double limiteCompra;

    @Column(name = "dia_fechamento", nullable = false)
    private int diaFechamentoFatura;
    
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PedidoModel> pedidos;

    public void setNomeCliente(String nome) {
        if (nome.length() >= 100) {
            throw new ClienteException("O nome do cliente ultrapassa o limite de 100 caracteres!");
        } else if (nome.isEmpty()) {
            throw new ClienteException("O nome do cliente não foi informado!");
        }
        this.nomeCliente = nome;
    }

    public void setLimiteCompra(Double limiteCompra) {
        if (limiteCompra < 0) {
            throw new IllegalArgumentException("O limite de compra não pode ser negativo!");
        }
        this.limiteCompra = limiteCompra;
    }
    
}
