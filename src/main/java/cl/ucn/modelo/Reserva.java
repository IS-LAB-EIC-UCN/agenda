package cl.ucn.modelo;

import java.util.List;

import org.joda.time.DateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="reserva")
public class Reserva {

	@Id
	@Column(name="id_reserva")
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	int idReserva;
	DateTime fechaEntrada;
	DateTime fechaSalida;
	double pago;
	
	public int getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	public DateTime getFechaEntrada() {
		return fechaEntrada;
	}
	public void setFechaEntrada(DateTime fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}
	public DateTime getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(DateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public double getPago() {
		return pago;
	}
	public void setPago(double pago) {
		this.pago = pago;
	}
	
	@ManyToOne
    @JoinColumn(name = "rut", referencedColumnName = "rut")
    private Cliente cliente;
	
	@OneToMany(mappedBy = "reserva")
	private List<Habitacion> habitaciones;
	
	
}
