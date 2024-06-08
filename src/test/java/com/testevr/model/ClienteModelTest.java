package com.testevr.model;

import com.testevr.exception.ClienteException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 * @author Diego Barbosa
 */
public class ClienteModelTest {

    @Test
    public void testSetNomeClienteComNomeValido() {
        ClienteModel cliente = new ClienteModel();
        String nomeValido = "Diego Barbosa";
        cliente.setNomeCliente(nomeValido);
        assertEquals(nomeValido, cliente.getNomeCliente());
    }

    @Test
    public void testSetNomeClienteComNomeMuitoLongo() {
        ClienteModel cliente = new ClienteModel();
        String nomeMuitoLongo = "A".repeat(101);
        try {
            cliente.setNomeCliente(nomeMuitoLongo);
            fail("Esperava uma ClienteException");
        } catch (ClienteException e) {
            assertEquals("O nome do cliente ultrapassa o limite de 100 caracteres!", e.getMessage());
        }
    }

    @Test
    public void testSetNomeClienteComNomeVazio() {
        ClienteModel cliente = new ClienteModel();
        String nomeVazio = "";
        try {
            cliente.setNomeCliente(nomeVazio);
            fail("Esperava uma ClienteException");
        } catch (ClienteException e) {
            assertEquals("O nome do cliente não foi informado!", e.getMessage());
        }
    }

    @Test
    public void testSetLimiteCompraValido() {
        ClienteModel cliente = new ClienteModel();
        cliente.setLimiteCompra(1000.0);
        assertEquals(1000.0, cliente.getLimiteCompra(), 0.001);
    }

    @Test
    public void testSetLimiteCompraNegativo() {
        ClienteModel cliente = new ClienteModel();
        try {
            cliente.setLimiteCompra(-100.0);
            fail("Esperava uma IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("O limite de compra não pode ser um valor negativo!", e.getMessage());
        }
    }

}
