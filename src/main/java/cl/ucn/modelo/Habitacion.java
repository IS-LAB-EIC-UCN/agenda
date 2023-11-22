package cl.ucn.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="habitacion")
public class Habitacion {

	@Id
	int numero;
	@Column(name="cantidad_camas")
	int cantidadCamas;
	
	
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
	
	@ManyToOne
    @JoinColumn(name = "id_reserva", referencedColumnName = "id_reserva")
    private Reserva reserva;
	
}
