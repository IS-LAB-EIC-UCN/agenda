package cl.ucn.persistencia.api;

import cl.ucn.modelo.Habitacion;

public interface IStorageHabitacion {

	public void getHabitacion(int numero);
	public void guardarHabitacion(Habitacion habitacion);
	public void eliminarHabitacion(int numero);
}
