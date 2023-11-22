package cl.ucn.persistencia.api;

import cl.ucn.modelo.Reserva;

public interface IStorageReserva {

	public Reserva getReserva(int idReserva);
	public void guardarReserva(Reserva reserva);
	public void eliminarReserva(int idReserva);
	public void imprimirReservas();
	
}
