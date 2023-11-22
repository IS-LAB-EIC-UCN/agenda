package cl.ucn.persistencia.api;

import cl.ucn.modelo.*;

public interface IStorageCliente {

	public Cliente getCliente(int rut);
	public void guardarCliente(Cliente cliente);
	public void eliminarCliente(int rut);
	
}
