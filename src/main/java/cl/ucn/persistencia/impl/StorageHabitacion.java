package cl.ucn.persistencia.impl;

import cl.ucn.modelo.Habitacion;
import cl.ucn.persistencia.api.IStorageHabitacion;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
@LocalBean
public class StorageHabitacion implements IStorageHabitacion{

	@PersistenceContext
	protected EntityManager em;
	
	@Override
	public Habitacion getHabitacion(int numero) {
		// TODO Auto-generated method stub
		Query q = em.createQuery("SELECT p FROM Habitacion p WHERE p.numero = :numero");
		q.setParameter("numero", numero);
		Habitacion habitacion = (Habitacion) q.getSingleResult();
		return habitacion;
	}

	@Override
	public void guardarHabitacion(Habitacion habitacion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarHabitacion(int numero) {
		// TODO Auto-generated method stub
		
	}

}
