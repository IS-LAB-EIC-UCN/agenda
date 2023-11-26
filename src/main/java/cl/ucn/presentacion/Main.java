package cl.ucn.presentacion;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.InitialContext;

import org.joda.time.DateTime;

import cl.ucn.modelo.Cliente;
import cl.ucn.modelo.Habitacion;
import cl.ucn.modelo.Reserva;
import cl.ucn.persistencia.api.IStorageCliente;
import cl.ucn.persistencia.api.IStorageHabitacion;
import cl.ucn.persistencia.api.IStorageReserva;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;


@Singleton
@Startup
public class Main {

	private static IStorageCliente storableCliente = null; 
	private static IStorageHabitacion storableHabitacion = null; 
	private static IStorageReserva storableReserva = null; 
	Logger logger = Logger.getLogger(Main.class.getName());


	@PostConstruct
	public void initialize() {

		try{
			InitialContext ctx1 = new InitialContext();
			storableCliente = (IStorageCliente) ctx1.lookup("java:app/wildfly-fabric8/StorageCliente");
		}catch (Exception e) {
			System.out.println("Problems:"+ e);
		}

		try{
			InitialContext ctx2 = new InitialContext();
			storableHabitacion = (IStorageHabitacion) ctx2.lookup("java:app/wildfly-fabric8/StorageHabitacion");
		}catch (Exception e) {
			System.out.println("Problems:"+ e);
		}

		try{
			InitialContext ctx3 = new InitialContext();
			storableReserva = (IStorageReserva) ctx3.lookup("java:app/wildfly-fabric8/StorageReserva");
		}catch (Exception e) {
			System.out.println("Problems:"+ e);
		}

		// Creacion de un cliente
		Cliente cliente = new Cliente();
		cliente.setRut(12345678);
		cliente.setNombre("Juan Perez");
		cliente.setDireccion("Benavente 123");
		cliente.setEmail("juan.perez@gmail.com");
		cliente.setCelular(987654321);
		storableCliente.guardarCliente(cliente);

		// Creacion de una carga
		cliente = new Cliente();
		cliente.setRut(28789272);
		cliente.setNombre("Maria Perez");
		cliente.setDireccion("Benavente 123");
		cliente.setEmail("juan.perez@gmail.com");
		cliente.setCelular(987654321);
		storableCliente.guardarCliente(cliente);

		// Adicionar una carga
		Cliente cli = storableCliente.getCliente(12345678);
		cli.ingresarCarga(cliente);

		// Crear una reserva
		Reserva reserva = new Reserva();
		reserva.setFechaEntrada(new DateTime(2022,11,28,15,00,00));
		reserva.setFechaSalida(new DateTime(2022,11,29,12,00,00));
		reserva.setPago(20000);
		storableReserva.guardarReserva(reserva);

		// Elegir habitacion y asociar a una reserva
		Habitacion habitacion = storableHabitacion.getHabitacion(3);
		habitacion.ingresarReserva(reserva);
		reserva.ingresarHabitacion(habitacion);

		//Asociar la reserva al cliente
		cli.ingresarReserva(reserva);
		reserva.setCliente(cli);

		//-------------------------------Cliente 2------------------------------------
		//----------------------------------------------------------------------------
		//----------------------------------------------------------------------------
		// Creacion de un cliente

		cliente = new Cliente();
		cliente.setRut(145686890);
		cliente.setNombre("Diego Urzua");
		cliente.setDireccion("Huanhuali 456");
		cliente.setEmail("diego.urzua@gmail.com");
		cliente.setCelular(946373890);
		storableCliente.guardarCliente(cliente);

		reserva = new Reserva();
		reserva.setFechaEntrada(new DateTime(2022,11,29,13,00,00));
		reserva.setFechaSalida(new DateTime(2022,11,30,12,00,00));
		reserva.setPago(20000);
		storableReserva.guardarReserva(reserva);

		// Elegir habitacion y asociar a una reserva
		habitacion = storableHabitacion.getHabitacion(3);
		habitacion.ingresarReserva(reserva);
		reserva.ingresarHabitacion(habitacion);

		//Asociar la reserva al cliente
		cliente.ingresarReserva(reserva);
		reserva.setCliente(cliente);

		//-------------------------------------------
		// Chequear disponibilidad
		DateTime fechaEntrada = new DateTime(2022,11,30,11,00,00);
		DateTime fechaSalida = new DateTime(2022,12,01,12,00,00);
		Reserva consultaReserva = storableReserva.verificarDisponibilidad(3, fechaEntrada, fechaSalida);
		if (consultaReserva != null)
			logger.log(Level.INFO, "La reserva " + consultaReserva.getIdReserva() + " esta activa en las fechas: " + 
					consultaReserva.getFechaEntrada().toString() + "-" + consultaReserva.getFechaSalida().toString());
		else
			logger.log(Level.INFO, "No existen reservar, habitacion disponible" );
		
		//--------------------------------------------
		// Imprimir agenda
		logger.log(Level.INFO, storableReserva.imprimirReservas(3));
	}

}
