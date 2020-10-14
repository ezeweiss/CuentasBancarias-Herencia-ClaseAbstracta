package ar.edu.unlam.pb2;

public class CuentaSueldo extends Cuenta{


	public CuentaSueldo(String nombreCliente, String apellidoCliente, Integer dni, Double saldo) {
		super(nombreCliente,apellidoCliente,dni,saldo);
	}
	
	public void depositar(Double ingresoDinero) {
		this.saldo = this.saldo + ingresoDinero;
	}
	
	public void extraer(Double extraccionDinero) {
		
		
		if(extraccionDinero <= this.saldo) {
		 this.saldo = this.saldo - extraccionDinero;
		}
		
		else {
			System.out.println("Se supero el limite de dinero disponible");
		}
		
		
	}

	
	
}
