package cl.ucn.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cl.ucn.modelo.Cliente;

class TestCliente {

	@Test
	public void testCrearCliente() {
	    Cliente cliente = new Cliente(123456789, "John Doe", "Larrondo 731", 123456789 , "john@example.com");
	    assertNotNull(cliente);
	    assertEquals(123456789, cliente.getRut());
	    assertEquals("John Doe", cliente.getNombre());
	    assertEquals("Larrondo 731", cliente.getDireccion());
	    assertEquals(123456789, cliente.getCelular());
	    assertEquals("john@example.com", cliente.getEmail());
	}

}
