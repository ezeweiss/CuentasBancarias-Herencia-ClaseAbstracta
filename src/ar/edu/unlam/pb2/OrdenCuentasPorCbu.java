package ar.edu.unlam.pb2;

import java.util.Comparator;

public class OrdenCuentasPorCbu implements Comparator<Cuenta>{

	@Override
	public int compare(Cuenta o1, Cuenta o2) {
		return -1*(o1.getCbu().compareTo(o2.getCbu()));
	}

}
