package ar.edu.unlam.pb2;

public class CuentaSueldo extends Cuenta{


	public CuentaSueldo(String nombreCliente, String apellidoCliente, Integer cbu, Double saldo) {
		super(nombreCliente,apellidoCliente,cbu,saldo);
	}
	
	public void extraer(Double extraccionDinero) throws MontoInsuficienteException, MontoInvalidoException {

		if(extraccionDinero <= this.saldo) {
		 this.saldo = this.saldo - extraccionDinero;
		}
		
		if(this.saldo - extraccionDinero > this.saldo) {
			throw new MontoInsuficienteException();
		}
		
		if(extraccionDinero < 0) {
			throw new MontoInvalidoException();
		}
		
		
	}

	@Override
	public int compareTo(Cuenta cbu) {
		return (this.getCbu().compareTo(cbu.getCbu()));
	}

	
	
}
