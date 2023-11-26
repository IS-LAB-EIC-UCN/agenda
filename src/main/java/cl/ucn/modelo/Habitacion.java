package cl.ucn.modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="habitacion")
public class Habitacion {

	@Id
	int numero;
	@Column(name="cantidad_camas")
	int cantidadCamas;
	
	@ManyToMany(mappedBy="habitaciones")
	private List<Reserva> reservas = new ArrayList<Reserva>();
	
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getCantidadCamas() {
		return cantidadCamas;
	}
	public void setCantidadCamas(int cantidadCamas) {
		this.cantidadCamas = cantidadCamas;
	}
	
	public void ingresarReserva(Reserva reserva) {
		
		this.reservas.add(reserva);
		
	}
	
	
	
}
