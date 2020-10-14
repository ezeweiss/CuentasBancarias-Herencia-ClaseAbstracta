package ar.edu.unlam.pb2;

public abstract class Cuenta {

	private String nombreCliente;
	private String apellidoCliente;
	private Integer dni;
	protected Double saldo;
	
	public Cuenta(String nombreCliente, String apellidoCliente, Integer dni, Double saldo) {
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.dni = dni;
		this.saldo = saldo;
	}
	
	public abstract void depositar(Double ingresoDinero);
	public abstract void extraer(Double extraccionDinero);
	

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
}
