package com.sistema.solar.modelo;

import java.awt.geom.Point2D;

public class Planeta {
	
	private double angulo;
	private double velocidadAngular;
	private double radio;
	private Sentido sentido;
	
	public Planeta(double anguloInicial, double velocidadAngular, double radio, Sentido sentido) {
		this.setAngulo(anguloInicial);
		this.setVelocidadAngular(velocidadAngular);
		this.setRadio(radio);
		this.setSentido(sentido);
	}

	public double getAngulo() {
		return angulo;
	}

	public void setAngulo(double anguloInicial) {
		this.angulo = anguloInicial;
	}

	public double getVelocidadAngular() {
		return velocidadAngular;
	}

	public void setVelocidadAngular(double velocidadAngular) {
		this.velocidadAngular = velocidadAngular;
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	public Sentido getSentido() {
		return sentido;
	}

	public void setSentido(Sentido sentido) {
		this.sentido = sentido;
	}

	@Override
	public String toString() {
		return "Planeta [angulo=" + angulo + ", velocidadAngular=" + velocidadAngular + ", radio=" + radio
				+ ", sentido=" + sentido + "]";
	}

	public Point2D getPunto() {
		double x = this.radio * Math.cos(Math.toRadians(this.angulo));
		double y = this.radio * Math.sin(Math.toRadians(this.angulo));
		return new Point2D.Double(Math.round(x * 100.0) / 100.0, Math.round(y * 100.0) / 100.0);
	}

	public void avanzar(int cantidadDias) {
		double nuevoAngulo = this.getAngulo();
		if (this.getSentido() == Sentido.ANTIHORARIO) {
			nuevoAngulo += this.getVelocidadAngular() * cantidadDias;
		} else {
			nuevoAngulo -= this.getVelocidadAngular() * cantidadDias;
		}
		this.setAngulo(nuevoAngulo);
	}
}
