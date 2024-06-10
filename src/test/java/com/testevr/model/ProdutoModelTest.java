package com.testevr.model;

import com.testevr.exception.ClienteException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 * @author Diego Barbosa
 */
public class ProdutoModelTest {
    
    @Test
    public void testSetDescricaoProdutoComDescricaoValida() {
        ProdutoModel produto = new ProdutoModel();
        String descricaoValida = "Produto Teste";
        produto.setDescricaoProduto(descricaoValida);
        assertEquals(descricaoValida, produto.getDescricaoProduto());
    }

    @Test
    public void testSetDescricaoProdutoComDescricaoExtensa() {
        ProdutoModel produto = new ProdutoModel();
        String descricaoMuitoLonga = "A".repeat(151);
        try {
            produto.setDescricaoProduto(descricaoMuitoLonga);
            fail("Esperava uma ClienteException");
        } catch (ClienteException e) {
            assertEquals("O nome do produto ultrapassa o limite de 150 caracteres!", e.getMessage());
        }
    }

    @Test
    public void testSetDescricaoProdutoComDescricaoVazia() {
        ProdutoModel produto = new ProdutoModel();
        String descricaoVazia = "";
        try {
            produto.setDescricaoProduto(descricaoVazia);
            fail("Esperava uma ClienteException");
        } catch (ClienteException e) {
            assertEquals("O nome do produto nao foi informado!", e.getMessage());
        }
    }

    @Test
    public void testSetValorProdutoValido() {
        ProdutoModel produto = new ProdutoModel();
        produto.setValorProduto(100.0);
        assertEquals(100.0, produto.getValorProduto(), 0.001);
    }

    @Test
    public void testSetValorProdutoNegativo() {
        ProdutoModel produto = new ProdutoModel();
        try {
            produto.setValorProduto(-50.0);
            fail("Esperava uma IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("O valor do produto não pode ser negativo!", e.getMessage());
        }
    }
    
}
