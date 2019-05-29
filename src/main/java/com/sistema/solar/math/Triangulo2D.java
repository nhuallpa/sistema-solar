package com.sistema.solar.math;

import java.awt.geom.Point2D;
/**
 * Modela un triangulo 2D en base a tres puntos en coordenadas cartesianas.
 * @author nestor
 *
 */
public class Triangulo2D {

	private Point2D puntoA; 
	private Point2D puntoB; 
	private Point2D puntoC;
	
	public Triangulo2D(Point2D puntoA, Point2D puntoB, Point2D puntoC) {
		this.setPuntoA(puntoA);
		this.setPuntoB(puntoB);
		this.setPuntoC(puntoC);
	}

	public Point2D getPuntoA() {
		return puntoA;
	}

	public void setPuntoA(Point2D puntoA) {
		this.puntoA = puntoA;
	}

	public Point2D getPuntoB() {
		return puntoB;
	}

	public void setPuntoB(Point2D puntoB) {
		this.puntoB = puntoB;
	}

	public Point2D getPuntoC() {
		return puntoC;
	}

	public void setPuntoC(Point2D puntoC) {
		this.puntoC = puntoC;
	}

	public boolean contiene(Point2D punto) {
		
        double A = area(this.getPuntoA(), this.getPuntoB(), this.getPuntoC()); 
       
        double A1 = area(punto, this.getPuntoB(), this.getPuntoC()); 
        double A2 = area(this.getPuntoA(), punto, this.getPuntoC()); 
        double A3 = area(this.getPuntoA(), this.getPuntoB(), punto); 
         
        return (A == A1 + A2 + A3); 
		
	}
	
	private double area(Point2D punto1, Point2D punto2, Point2D punto3) 
	{ 
		return Math.abs((punto1.getX()*(punto2.getY()-punto3.getY()) 
						+ punto2.getX()*(punto3.getY()-punto1.getY())
						+ punto3.getX()*(punto1.getY()-punto2.getY()))/2.0); 
	}

	public double calcularArea() {
		return area(this.getPuntoA(), this.getPuntoB(), this.getPuntoC());
	} 
	
}
