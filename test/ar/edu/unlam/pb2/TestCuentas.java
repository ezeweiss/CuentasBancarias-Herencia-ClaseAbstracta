package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCuentas {

	@Test
	public void testQueDepositeDineroEnCuentaSueldo() {
		Cuenta miCuenta = new CuentaSueldo("Wanchope", "Abila", 49876542, 5000.0);
		
		miCuenta.depositar(2000.0);
		
		Double valorEsperado = 7000.0;
		Double valorObtenido = miCuenta.getSaldo();
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void testQueExtraigaDineroEnCuentaSueldo() throws MontoInsuficienteException, MontoInvalidoException {
		Cuenta miCuenta = new CuentaSueldo("Wanchope", "Abila", 49876542, 5000.0);
		
		miCuenta.extraer(4000.0);
		
		Double valorEsperado = 1000.0;
		Double valorObtenido = miCuenta.getSaldo();
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void testQueExtraigaEnCajaDeAhorros() throws MontoInvalidoException, MontoInsuficienteException {
		Cuenta miCaja = new CajaAhorro("Carlos","Bianchi", 34567654, 1000.0);
		
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
	public void testQueExtraigaDineroEnCuentaCorriente() throws MontoInsuficienteException, MontoInvalidoException{
		Cuenta miCuentaCorriente = new CuentaCorriente("Carlos","Bianchi", 34567654, 2000.0);
		
		miCuentaCorriente.extraer(200.0);
		miCuentaCorriente.extraer(200.0);
		miCuentaCorriente.extraer(200.0);
		miCuentaCorriente.extraer(200.0);
		
		
		Double valorEsperado = 1200.0;
		Double valorObtenido = miCuentaCorriente.getSaldo();
		assertEquals(valorEsperado, valorObtenido);
		
		
	}
	
	@Test
	public void testQueBusqueUnaCuenta() throws CuentaNotFoundException {
		Banco miBanco = new Banco("Provincia");
		Cuenta miCuenta = new CuentaSueldo("Diego", "Maradona", 2352, 56000.0);
		
		miBanco.agregarCuenta(miCuenta);
		
		Integer cbu = 2352;
		Cuenta valorObtenido = miBanco.buscarCuenta(cbu);
		assertEquals(cbu, valorObtenido.getCbu());
		
	}
	
	@Test 
	public void testQueVerifiqueQueSeRealiceUnaTransferencia() throws MontoInsuficienteException, MontoInvalidoException, CuentaNotFoundException {
		Banco miBanco = new Banco("Santander Rio");
		Cuenta miCuenta = new CuentaSueldo("Marcos", "Diaz", 345, 60000.0);
		Cuenta miCuenta2 = new CuentaSueldo("Rolando", "Schiavi", 111, 5000.0);
		
		miBanco.agregarCuenta(miCuenta);
		miBanco.agregarCuenta(miCuenta2);
		
		Double valorEsperado = 9000.0;
		Cuenta valorObtenido = miBanco.realizarTransferencia(345, 111, 4000.0);
		assertEquals(valorEsperado, valorObtenido.getSaldo());
		
		
	}
	
	@Test(expected=CuentaNotFoundException.class)
	public void testQueEspereUnaExcepcion() throws CuentaNotFoundException{
		Banco miBanco = new Banco("Provincia");
		Cuenta miCuenta = new CuentaSueldo("Diego", "Maradona", 2352, 56000.0);
		
		miBanco.agregarCuenta(miCuenta);
		
		Integer cbu = 2351;
		Cuenta valorObtenido = miBanco.buscarCuenta(cbu);
		assertEquals(cbu, valorObtenido.getCbu());
		
	}
	
	@Test
	public void testQueTrataUnaExcepcionAlNoEncontrarUnaCuenta() {
		Banco miBanco = new Banco("Provincia");
		Cuenta miCuenta = new CuentaSueldo("Diego", "Maradona", 2352, 56000.0);
		
		miBanco.agregarCuenta(miCuenta);
		
		try {
			assertEquals(2352, miBanco.buscarCuenta(2353));
		}
		
		catch(Exception e) {
			assertEquals("La cuenta no existe",	e.getMessage());
		}
	}
	
	@Test
	public void testQueMuestreListaDeCuentasConSaldoNegativoOrdenadasDeFormaDescendente() {
		Banco miBanco = new Banco("Nacion");
		Cuenta miCuenta = new CuentaSueldo("Martin", "Palermo", 333, -50000.0 );
		Cuenta miCuenta2 = new CajaAhorro("Pol", "Fernandez", 777, -8000.0);
		Cuenta miCuenta3 = new CuentaCorriente("Miguel", "Russo", 444, -7500.0);
		Cuenta miCuenta4 = new CajaAhorro("Ricardo", "Gareca", 453, -8500.0);
		Cuenta miCuenta5 = new CajaAhorro("Jorman", "Campuzano", 999, 8500.0);
		
		miBanco.agregarCuenta(miCuenta);
		miBanco.agregarCuenta(miCuenta2);
		miBanco.agregarCuenta(miCuenta3);
		miBanco.agregarCuenta(miCuenta4);
		miBanco.agregarCuenta(miCuenta5);

		for(Cuenta cuenta : miBanco.obtenerListaDeCuentasConSaldoNegativoOrdenadasPorCbuDeFormaDescendente() ) {
			System.out.println(cuenta);
		}
		
		
	}
}
