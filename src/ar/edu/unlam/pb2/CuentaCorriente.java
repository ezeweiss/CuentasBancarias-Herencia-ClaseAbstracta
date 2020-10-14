package ar.edu.unlam.pb2;

public class CuentaCorriente extends Cuenta{

	private Double saldoDescubierto = 200.0;
	
	public CuentaCorriente(String nombreCliente, String apellidoCliente, Integer dni, Double saldo) {
		super(nombreCliente, apellidoCliente, dni, saldo);
	}
	
	@Override
	public void extraer(Double extraccionDinero) {
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
		
		else {
			System.out.println("Se supero el limite de descubierto y saldo");
		}
	}

	@Override
	public void depositar(Double ingresoDinero) {
		this.saldo = this.saldo + ingresoDinero;
		
	}

}
