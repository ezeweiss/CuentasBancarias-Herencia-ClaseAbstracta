package ar.edu.unlam.pb2;

public class CuentaCorriente extends Cuenta{

	private Double saldoDescubierto = 200.0;
	
	public CuentaCorriente(String nombreCliente, String apellidoCliente, Integer cbu, Double saldo) {
		super(nombreCliente, apellidoCliente, cbu, saldo);
	}
	
	@Override
	public void extraer(Double extraccionDinero) throws MontoInvalidoException, MontoInsuficienteException {
		Double descubiertoDisponible = 0.0;
		Double descubiertoUsado = 0.0;
		Double totalDeuda = 0.0;
		
		if(extraccionDinero < this.saldo){
			this.saldo = this.saldo - extraccionDinero;
		}
		
		else if(this.saldo + this.saldoDescubierto >= extraccionDinero) {
			this.saldo = this.saldo - extraccionDinero;
			descubiertoDisponible = this.saldo + this.saldoDescubierto;
			descubiertoUsado =  this.saldoDescubierto - descubiertoDisponible;
			totalDeuda = descubiertoUsado + (descubiertoUsado * 0.05);
		}
		
		 if(extraccionDinero < 0) {
			throw new MontoInvalidoException();
		}
		
		 if( extraccionDinero > this.saldo + this.saldoDescubierto) {
				throw new MontoInsuficienteException();
			}
		
	


	}

	@Override
	public int compareTo(Cuenta cbu) {
		return (this.getCbu().compareTo(cbu.getCbu()));
	}

}
