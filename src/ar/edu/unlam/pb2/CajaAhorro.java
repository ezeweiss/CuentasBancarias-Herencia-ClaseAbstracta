package ar.edu.unlam.pb2;

public class CajaAhorro extends Cuenta{

	private Integer cantidadExtracciones = 0;
	
	public CajaAhorro(String nombreCliente, String apellidoCliente, Integer dni, Double saldo) {
		super(nombreCliente, apellidoCliente, dni, saldo);
	}
	
	
	public void extraer(Double extraccionDinero) {
		
		this.cantidadExtracciones = this.cantidadExtracciones + 1;
		if(this.cantidadExtracciones > 5) {
			this.saldo = this.saldo - extraccionDinero - 6.0;
		}
		else {
			this.saldo = this.saldo - extraccionDinero;
		}
	}


	@Override
	public void depositar(Double ingresoDinero) {
		this.saldo = this.saldo + ingresoDinero;
		
	}


}