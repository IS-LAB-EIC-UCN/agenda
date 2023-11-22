package cl.ucn.presentacion;
import javax.naming.InitialContext;

import cl.ucn.modelo.*;
import cl.ucn.persistencia.api.IStorageCliente;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;


@Singleton
@Startup
public class Main {

	private static IStorageCliente storable = null; 

	@PostConstruct
    public void initialize() {
      
		try{
			InitialContext ctx = new InitialContext();
			storable = (IStorageCliente) ctx.lookup("java:app/wildfly-fabric8/StorageCliente");
		}catch (Exception e) {
			System.out.println("Problems:"+ e);
		}

		Cliente cliente = new Cliente();
		cliente.setRut(12345678);
		cliente.setNombre("Juan Perez");
		cliente.setDireccion("Benavente 123");
		cliente.setEmail("juan.perez@gmail.com");
		cliente.setCelular(987654321);

		storable.guardarCliente(cliente);
		
    }

}
