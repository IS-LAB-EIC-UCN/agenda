package cl.ucn.modelo;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="reserva")
public class Reserva {

	@Id
	@Column(name="id_reserva")
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	int idReserva;
	
	@Convert(converter = DateTimeConverter.class)
	DateTime fechaEntrada;
	@Convert(converter = DateTimeConverter.class)
	DateTime fechaSalida;
	double pago;
	
	@ManyToOne
    @JoinColumn(name = "rut", referencedColumnName = "rut")
    private Cliente cliente;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
		    name = "reserva_habitacion",
		    joinColumns = @JoinColumn(name = "id_reserva"),
		    inverseJoinColumns = @JoinColumn(name = "numero")
		)
	private List<Habitacion> habitaciones = new ArrayList<Habitacion>();
	
	
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
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void ingresarHabitacion(Habitacion habitacion) {
		
		this.habitaciones.add(habitacion);
		
	}
	
}
