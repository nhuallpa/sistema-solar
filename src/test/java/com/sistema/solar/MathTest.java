package com.sistema.solar;


import static org.junit.Assert.assertEquals;

import java.awt.geom.Point2D;

import org.junit.Test;

import com.sistema.solar.math.Recta;
import com.sistema.solar.math.Triangulo2D;


public class MathTest {
	
	@Test
	public void rectaPendienteUno() {
		 Point2D punto1 = new Point2D.Double(1.0, 1.0);
		 Point2D punto2 = new Point2D.Double(2.0, 2.0);
		 
		 Point2D puntoContenido = new Point2D.Double(3.0, 3.0);
		 
		 Recta recta = new Recta();
		 recta.setLinea(punto1, punto2);
		 
		 assertEquals(true, recta.contiene(puntoContenido));
	}
	
	@Test
	public void rectaPerpendicularPuntoIncluido() {
		Point2D punto1 = new Point2D.Double(0.0, 1.0);
		 Point2D punto2 = new Point2D.Double(0.0, 2.0);
		 
		 Point2D puntoContenido = new Point2D.Double(0.0, 3.0);
		 
		 Recta recta = new Recta();
		 recta.setLinea(punto1, punto2);
		 
		 assertEquals(true, recta.contiene(puntoContenido));
	}
	
	@Test
	public void rectaPerpendicularPuntoNoIncluido() {
		Point2D punto1 = new Point2D.Double(0.0, 1.0);
		 Point2D punto2 = new Point2D.Double(0.0, 2.0);
		 
		 Point2D puntoContenido = new Point2D.Double(3.0, 3.0);
		 
		 Recta recta = new Recta();
		 recta.setLinea(punto1, punto2);
		 
		 assertEquals(false, recta.contiene(puntoContenido));
	}
	
	@Test
	public void rectaHorizontalPuntoIncluido() {
		Point2D punto1 = new Point2D.Double(1.0, 4.0);
		Point2D punto2 = new Point2D.Double(6.0, 4.0);

		Point2D puntoContenido = new Point2D.Double(3.0, 4.0);

		Recta recta = new Recta();
		recta.setLinea(punto1, punto2);

		assertEquals(true, recta.contiene(puntoContenido));
	}
	
	@Test
	public void rectaHorizontalPuntoNOIncluido() {
		Point2D punto1 = new Point2D.Double(1.0, 4.0);
		Point2D punto2 = new Point2D.Double(6.0, 4.0);

		Point2D puntoContenido = new Point2D.Double(3.0, 5.0);

		Recta recta = new Recta();
		recta.setLinea(punto1, punto2);

		assertEquals(false, recta.contiene(puntoContenido));
	}
	
	@Test
	public void trianguloNoContienePuntoP() {
		Point2D puntoA = new Point2D.Double(0.0, 0.0);
		Point2D puntoB = new Point2D.Double(10.0, 30.0);
		Point2D puntoC = new Point2D.Double(20.0, 0.0);
		
		Point2D puntoP = new Point2D.Double(20.0, 10.0);

		Triangulo2D triangulo2D = new Triangulo2D(puntoA, puntoB, puntoC);
		assertEquals(false, triangulo2D.contiene(puntoP));
	}

	@Test
	public void trianguloContienePuntoP() {
		Point2D puntoA = new Point2D.Double(0.0, 0.0);
		Point2D puntoB = new Point2D.Double(10.0, 30.0);
		Point2D puntoC = new Point2D.Double(20.0, 0.0);
		
		Point2D puntoP = new Point2D.Double(10.0, 10.0);

		Triangulo2D triangulo2D = new Triangulo2D(puntoA, puntoB, puntoC);
		assertEquals(true, triangulo2D.contiene(puntoP));
	}
}
