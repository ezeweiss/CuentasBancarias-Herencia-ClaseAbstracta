package ar.edu.unlam.pb2;

public class CuentaNotFoundException extends Exception {
	
	public CuentaNotFoundException() {
		super("La cuenta no existe");
	}

}
