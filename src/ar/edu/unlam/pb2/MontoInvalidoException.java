package ar.edu.unlam.pb2;

public class MontoInvalidoException extends Exception {

	public MontoInvalidoException() {
		super("El monto a retirar es menor a 0");
	}
}
