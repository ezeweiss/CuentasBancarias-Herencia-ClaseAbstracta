package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCuentas {

	@Test
	public void testQueDepositeDineroEnCuentaSueldo() {
		CuentaSueldo miCuenta = new CuentaSueldo("Wanchope", "Abila", 49876542, 5000.0);
		
		miCuenta.depositar(2000.0);
		
		Double valorEsperado = 7000.0;
		Double valorObtenido = miCuenta.getSaldo();
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void testQueExtraigaDineroEnCuentaSueldo() {
		CuentaSueldo miCuenta = new CuentaSueldo("Wanchope", "Abila", 49876542, 5000.0);
		
		miCuenta.extraer(4000.0);
		
		Double valorEsperado = 1000.0;
		Double valorObtenido = miCuenta.getSaldo();
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void testQueExtraigaEnCajaDeAhorros() {
		CajaAhorro miCaja = new CajaAhorro("Carlos","Bianchi", 34567654, 1000.0);
		
		miCaja.extraer(100.0);
		miCaja.extraer(100.0);
		miCaja.extraer(100.0);
		miCaja.extraer(100.0);
		miCaja.extraer(100.0);
		miCaja.extraer(100.0);
		miCaja.extraer(100.0);
		
		Double valorEsperado = 288.0;
		Double valorObtenido = miCaja.getSaldo();
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void testQueExtraigaDineroEnCuentaCorriente(){
		CuentaCorriente miCuentaCorriente = new CuentaCorriente("Carlos","Bianchi", 34567654, 1000.0);
		
		miCuentaCorriente.extraer(200.0);
		miCuentaCorriente.extraer(200.0);
		miCuentaCorriente.extraer(200.0);
		miCuentaCorriente.extraer(200.0);
		
		
		Double valorEsperado = 200.0;
		Double valorObtenido = miCuentaCorriente.getSaldo();
		assertEquals(valorEsperado, valorObtenido);
		
		
	}
}
