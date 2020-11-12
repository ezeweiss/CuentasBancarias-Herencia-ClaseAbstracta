package ar.edu.unlam.pb2;

public class CajaAhorro extends Cuenta{

	private Integer cantidadExtracciones = 0;
	
	public CajaAhorro(String nombreCliente, String apellidoCliente, Integer cbu, Double saldo) {
		super(nombreCliente, apellidoCliente,cbu, saldo);
	}
	
	
	public void extraer(Double extraccionDinero) throws MontoInvalidoException, MontoInsuficienteException {
		
		this.cantidadExtracciones = this.cantidadExtracciones + 1;
		if(this.cantidadExtracciones > 5) {
			this.saldo = this.saldo - extraccionDinero - 6.0;
		}
		if(this.cantidadExtracciones <= 5) {
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