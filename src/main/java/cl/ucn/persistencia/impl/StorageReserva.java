package cl.ucn.persistencia.impl;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import cl.ucn.modelo.Reserva;
import cl.ucn.persistencia.api.IStorageReserva;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
@LocalBean
public class StorageReserva implements IStorageReserva {

	@PersistenceContext
	protected EntityManager em;

	@Override
	public Reserva getReserva(int idReserva) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardarReserva(Reserva reserva) {
		// TODO Auto-generated method stub
		em.persist(reserva);
		em.flush();
	}

	@Override
	public void eliminarReserva(int idReserva) {
		// TODO Auto-generated method stub

	}

	@Override
	public String imprimirReservas(int numeroHabitacion) {
		// TODO Auto-generated method stub
		String info = "";
		Query q = em.createQuery("SELECT r FROM Reserva r JOIN r.habitaciones h WHERE h.numero = :numeroHabitacion");
		q.setParameter("numeroHabitacion", numeroHabitacion);
		List<Reserva> reservas = (List<Reserva>) q.getResultList();
		for (Reserva reserva : reservas) {
			info = info + "\n";
			info = info + "N Reserva: " + reserva.getIdReserva() + "\n";
			info = info + "Cliente: " + reserva.getCliente().getNombre() + "\n";
			info = info + "Fecha Entrada: " + reserva.getFechaEntrada().toString() + "\n";
			info = info + "Fecha Salida: " + reserva.getFechaSalida().toString() + "\n";
			info = info + "---------------------------------------------------\n";
		}
		
		return info;
	}

	@Override
	public Reserva verificarDisponibilidad(int numeroHabitacion, DateTime fechaEntrada, DateTime fechaSalida ) {
		// TODO Auto-generated method stub

		Query q = em.createQuery("SELECT r FROM Reserva r JOIN r.habitaciones h WHERE h.numero = :numeroHabitacion");
		q.setParameter("numeroHabitacion", numeroHabitacion);
		List<Reserva> reservas = (List<Reserva>) q.getResultList();

		for (Reserva reserva : reservas) {

			Interval interval1 = new Interval(reserva.getFechaEntrada(), reserva.getFechaSalida());
			Interval interval2 = new Interval(fechaEntrada, fechaSalida);

			if (reserva.getFechaSalida().isBefore(DateTime.now()))
				if (interval1.overlaps(interval2))
					return reserva;
		}

		return null;
	}
}
