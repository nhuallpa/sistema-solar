package com.sistema.solar.math;

import java.awt.geom.Point2D;

public class Recta {

	private double ordenadaY;
	private double pendiente;
	
	private boolean rectaVertical = false;
	
	private double ordenadaX;

	public void setLinea(Point2D punto1, Point2D punto2) {
		
		double numerador = (punto1.getY() - punto2.getY());
		double denominador = (punto1.getX() - punto2.getX()); 
		
		if (denominador != 0.0) {
			double pendiente = numerador / denominador;
			this.setPendiente(Math.round(pendiente * 100.0) / 100.0);
		} else {
			this.rectaVertical = true;
			this.ordenadaX = punto1.getX();
		}
		
		double ordenadaOrigen = punto1.getY() - this.pendiente * punto1.getX();
		this.setOrdenadaY(ordenadaOrigen);
	}

	public boolean contiene(Point2D punto) {
		boolean puntoContenido = false;
		if (this.rectaVertical) {
			if (punto.getX() == this.ordenadaX) {
				puntoContenido = true;
			} 
		} else {
			Double y = this.getPendiente() * punto.getX() + this.getOrdenadaY();
			y = Math.round(y * 100.0) / 100.0;
			puntoContenido = y.equals(punto.getY());
		}
		return puntoContenido;
	}

	public double getPendiente() {
		return pendiente;
	}

	public void setPendiente(double pendiente) {
		this.pendiente = pendiente;
	}

	public double getOrdenadaY() {
		return ordenadaY;
	}

	public void setOrdenadaY(double ordenadaY) {
		this.ordenadaY = ordenadaY;
	}

	@Override
	public String toString() {
		return "Recta [ordenadaY=" + ordenadaY + ", pendiente=" + pendiente + "]";
	}
	
	

}
