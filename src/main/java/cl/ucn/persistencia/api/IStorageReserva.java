package cl.ucn.persistencia.api;

import org.joda.time.DateTime;

import cl.ucn.modelo.Reserva;

public interface IStorageReserva {

	public Reserva getReserva(int idReserva);
	public void guardarReserva(Reserva reserva);
	public void eliminarReserva(int idReserva);
	public String imprimirReservas(int numeroHabitacion);
	public Reserva verificarDisponibilidad(int numeroHabitacion, DateTime fechaEntrada, DateTime fechaSalida);
	
}
