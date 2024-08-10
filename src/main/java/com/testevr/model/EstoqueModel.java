package com.testevr.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Diego Barbosa
 */
@Data
@NoArgsConstructor
@Entity(name = "estoque_produto")
public class EstoqueModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_codigo")
    private Long codigoEstoque;

    @ManyToOne
    @JoinColumn(name = "fk_codigo_produto", nullable = false)
    private ProdutoModel produto;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade = 0;
    
}
