package com.testevr.model;

import com.testevr.exception.ClienteException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Diego Barbosa
 */
@Data
@NoArgsConstructor
@Entity(name = "produtos")
public class ProdutoModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_codigo_produto")
    private Long codigoProduto;

    @Column(name = "descricao_produto", length = 151, nullable = false)
    private String descricaoProduto;

    @Column(name = "valor_produto", nullable = false)
    private Double valorProduto;

    public void setDescricaoProduto(String nome) {
        if (nome.length() >= 150) {
            throw new ClienteException("O nome do produto ultrapassa o limite de 150 caracteres!");
        } else if (nome.isEmpty()) {
            throw new ClienteException("O nome do produto nao foi informado!");
        }
        this.descricaoProduto = nome;
    }

    public void setValorProduto(Double valorProduto) {
        if (valorProduto < 0) {
            throw new IllegalArgumentException("O valor do produto não pode ser negativo!");
        }
        this.valorProduto = valorProduto;
    }

}
