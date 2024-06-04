package com.testevr.model;

import com.testevr.exception.ClienteException;
import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @Column(name = "dia_fechamento_fatura", nullable = false)
    private LocalDateTime diaFechamentoFatura;

    public void setNomeCliente(String nome) {
        if (nome.length() >= 100) {
            throw new ClienteException("O nome do cliente ultrapassa o limite de 100 caracteres!");
        } else if (nome.isEmpty()) {
            throw new ClienteException("O nome do cliente nao foi informado!");
        }
        this.nomeCliente = nome;
    }

}
