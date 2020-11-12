package ar.edu.unlam.pb2;

public class MontoInsuficienteException extends Exception {
	
	public MontoInsuficienteException() {
		super("El monto a retirar es mayor al que se posee");
	}

}
