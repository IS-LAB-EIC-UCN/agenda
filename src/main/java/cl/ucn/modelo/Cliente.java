package cl.ucn.modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente {

	@Id
	int rut;
	String nombre;
	String direccion;
	int celular;
	String email;

	@OneToMany(mappedBy = "cliente")
	private List<Reserva> reservas = new ArrayList<Reserva>();

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Cliente> cargas = new ArrayList<Cliente>();

	@ManyToOne
	@JoinColumn(name = "rut_titular")
	private Cliente cliente;

	public Cliente() {
		
	}
	
	public Cliente(int rut, String nombre, String direccion, int celular, String email) {
		super();
		this.rut = rut;
		this.nombre = nombre;
		this.direccion = direccion;
		this.celular = celular;
		this.email = email;
	}
	
	public int getRut() {
		return rut;
	}
	public void setRut(int rut) {
		this.rut = rut;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getCelular() {
		return celular;
	}
	public void setCelular(int celular) {
		this.celular = celular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
	
	public List<Cliente> getCargas() {
        return cargas;
    }

    public void setCargas(List<Cliente> cargas) {
        this.cargas = cargas;
    }

	public void ingresarCarga(Cliente carga) {
		
		carga.setCliente(this); 
		this.cargas.add(cliente);

	}
	public List<Reserva> getReservas() {
		return reservas;
	}
	
	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
	
	public void ingresarReserva(Reserva reserva) {
		
		this.reservas.add(reserva);
		
	}
	
	

}
