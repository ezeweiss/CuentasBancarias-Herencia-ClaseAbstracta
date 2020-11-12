package ar.edu.unlam.pb2;


import java.util.Comparator;
import java.util.TreeSet;

public class Banco {
	private String nombreBanco;
	private TreeSet<Cuenta> listaCuentas = new TreeSet<Cuenta>();
	
	public Banco(String nombreBanco) {
		this.nombreBanco = nombreBanco;
	}

	public Boolean agregarCuenta(Cuenta cuenta) {
		return this.listaCuentas.add(cuenta);
	}
	
	public Cuenta buscarCuenta(Integer cbu) throws CuentaNotFoundException {
		for(Cuenta cuenta : this.listaCuentas) {
			if(cuenta.getCbu().equals(cbu)) {
				return cuenta;
			}
		
		}
		throw new CuentaNotFoundException();
		
	}
	
	public Cuenta realizarTransferencia(Integer cbuOrigen, Integer cbuDestino, Double monto) throws CuentaNotFoundException, MontoInsuficienteException, MontoInvalidoException {
		
		Cuenta cuentaOrigen = this.buscarCuenta(cbuOrigen);
		Cuenta cuentaDestino = this.buscarCuenta(cbuDestino);
		
		cuentaOrigen.extraer(monto);
		cuentaDestino.depositar(monto);
		return cuentaDestino;
		
		
	}
	
	public TreeSet<Cuenta> obtenerListaDeCuentasConSaldoNegativoOrdenadasPorCbuDeFormaDescendente(){
		TreeSet<Cuenta> listaOrdenadaPorCbu = new TreeSet<>(new OrdenCuentasPorCbu());
		for(Cuenta cuenta : this.listaCuentas) {
			if(cuenta.getSaldo() < 0) {	
				listaOrdenadaPorCbu.add(cuenta);
			}
		}
		return listaOrdenadaPorCbu;
		
	}
	
	
	public String getNombreBanco() {
		return nombreBanco;
	}

	public void setNombreBanco(String nombreBanco) {
		this.nombreBanco = nombreBanco;
	}

	public TreeSet<Cuenta> getListaCuentas() {
		return listaCuentas;
	}

	public void setListaCuentas(TreeSet<Cuenta> listaCuentas) {
		this.listaCuentas = listaCuentas;
	}
	
	
	
	
}
