package com.sistema.solar;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.sistema.solar.modelo.Periodo;
import com.sistema.solar.modelo.Planeta;
import com.sistema.solar.modelo.Sentido;
import com.sistema.solar.modelo.SistemaSolar;

public class SistemaSolarTest {

	@Test
	public void planetasYSolAlineadosPeriodoSequia() {
		
		Planeta ferengi = new Planeta(90, 1 , 500, Sentido.HORARIO);
		Planeta betasoide = new Planeta(90, 3, 2000, Sentido.HORARIO);
		Planeta vulcano = new Planeta(90, 5, 1000, Sentido.ANTIHORARIO);
		Planeta sol = new Planeta(0, 0, 0, Sentido.ANTIHORARIO);
		
		SistemaSolar sistema = new SistemaSolar(sol, ferengi, betasoide, vulcano);
		
		Periodo periodo = sistema.getPeriodo();
		
		assertEquals(Periodo.SEQUIA, periodo);
	}
	
	@Test
	public void planetasNoAlineadosYSolDentroPeriodoLluvias() {
		
		Planeta ferengi = new Planeta(90, 1 , 500, Sentido.HORARIO);
		Planeta betasoide = new Planeta(225, 3, 2000, Sentido.HORARIO);
		Planeta vulcano = new Planeta(315, 5, 1000, Sentido.ANTIHORARIO);
		Planeta sol = new Planeta(0, 0, 0, Sentido.ANTIHORARIO);
		
		SistemaSolar sistema = new SistemaSolar(sol, ferengi, betasoide, vulcano);
		
		Periodo periodo = sistema.getPeriodo();
		
		assertEquals(Periodo.LLUVIOSO, periodo);
	}
	
	@Test
	public void planetasTrascurreUnDia() {
		
		Planeta ferengi = new Planeta(90, 1 , 500, Sentido.HORARIO);
		Planeta betasoide = new Planeta(90, 3, 2000, Sentido.HORARIO);
		Planeta vulcano = new Planeta(90, 5, 1000, Sentido.ANTIHORARIO);
		Planeta sol = new Planeta(0, 0, 0, Sentido.ANTIHORARIO);
		
		SistemaSolar sistema = new SistemaSolar(sol, ferengi, betasoide, vulcano);

		sistema.sumarCantidadDias(1);
		
		assertEquals(89.0, ferengi.getAngulo(), 0.01);
		assertEquals(87.0, betasoide.getAngulo(), 0.01);
		assertEquals(95.0, vulcano.getAngulo(), 0.01);
	}
}
