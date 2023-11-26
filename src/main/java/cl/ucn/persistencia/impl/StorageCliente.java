package cl.ucn.persistencia.impl;

import cl.ucn.modelo.Cliente;
import cl.ucn.persistencia.api.IStorageCliente;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
@LocalBean
public class StorageCliente implements IStorageCliente{

	@PersistenceContext
	protected EntityManager em;

	@Override
	public Cliente getCliente(int rut) {
		// TODO Auto-generated method stub
		Query q = em.createQuery("SELECT p FROM Cliente p WHERE p.rut = :rut");
		q.setParameter("rut", rut);
		Cliente cliente = (Cliente) q.getSingleResult();
		return cliente;
	}

	@Override
	public void guardarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		em.persist(cliente);
		em.flush();
	}

	@Override
	public void eliminarCliente(int rut) {
		// TODO Auto-generated method stub

	}


}
