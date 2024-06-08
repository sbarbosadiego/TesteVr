package com.testevr.controller;

import com.testevr.exception.ClienteException;
import com.testevr.model.ClienteModel;
import java.time.LocalDate;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Diego Barbosa
 */
public class ClienteControllerTest {
    
    private ClienteModel cliente;

    @Before
    public void setUp() {
        cliente = new ClienteModel();
    }

    @Test
    public void testSetNomeCliente_Valido() {
        String nome = "João da Silva";
        cliente.setNomeCliente(nome);
        assertEquals(nome, cliente.getNomeCliente());
    }

    @Test(expected = ClienteException.class)
    public void testSetNomeCliente_LimiteExcedido() {
        String nome = "João".repeat(11); // 11 * 4 = 44 caracteres
        cliente.setNomeCliente(nome);
    }

    @Test(expected = ClienteException.class)
    public void testSetNomeCliente_Vazio() {
        cliente.setNomeCliente("");
    }

    @Test
    public void testSetLimiteCompra_Valido() {
        double limiteCompra = 1000.0;
        cliente.setLimiteCompra(limiteCompra);
        assertEquals(limiteCompra, cliente.getLimiteCompra(), 0.01); // Delta para comparar doubles
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetLimiteCompra_Negativo() {
        double limiteCompra = -100.0;
        cliente.setLimiteCompra(limiteCompra);
    }

}
