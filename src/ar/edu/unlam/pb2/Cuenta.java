package ar.edu.unlam.pb2;

public abstract class Cuenta implements Comparable<Cuenta>{

	private String nombreCliente;
	private String apellidoCliente;
	private Integer cbu;
	protected Double saldo;
	
	public Cuenta(String nombreCliente, String apellidoCliente, Integer cbu, Double saldo) {
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.cbu = cbu;
		this.saldo = saldo;
	}
	
	public void depositar(Double ingresoDinero) {
		this.saldo = this.saldo + ingresoDinero;
	}
	public abstract void extraer(Double extraccionDinero) throws MontoInsuficienteException, MontoInvalidoException;
	

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

	public Integer getCbu() {
		return cbu;
	}

	public void setCbu(Integer cbu) {
		this.cbu = cbu;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Cuenta [nombreCliente=" + nombreCliente + ", apellidoCliente=" + apellidoCliente + ", cbu=" + cbu
				+ ", saldo=" + saldo + "]";
	}
	
	
	
}
