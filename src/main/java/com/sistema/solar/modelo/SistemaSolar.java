package com.sistema.solar.modelo;

import java.awt.geom.Point2D;

import com.sistema.solar.math.Recta;
import com.sistema.solar.math.Triangulo2D;
/**
 * Sistema solar que contiene los planetas Ferengi, Vetasoide, Vulcano y un Sol
 * @author nestor
 *
 */
public class SistemaSolar {

	private int nroDia;
	private EstadoSistemaSolar estado;
	private Planeta sol;
	private Planeta ferengi;
	private Planeta betasoide;
	private Planeta vulcano;
	
	public SistemaSolar(Planeta sol, Planeta ferengi, Planeta betasoide, Planeta vulcano) {
		super();
		this.nroDia = 0;
		this.sol = sol;
		this.ferengi = ferengi;
		this.betasoide = betasoide;
		this.vulcano = vulcano;
		this.actualizarEstado();
	}

	public SistemaSolar() {
		super();
	}

	public Planeta getFerengi() {
		return ferengi;
	}

	public void setFerengi(Planeta ferengi) {
		this.ferengi = ferengi;
	}

	public Planeta getBetasoide() {
		return betasoide;
	}

	public void setBetasoide(Planeta betasoide) {
		this.betasoide = betasoide;
	}

	public Planeta getVulcano() {
		return vulcano;
	}

	public void setVulcano(Planeta vulcano) {
		this.vulcano = vulcano;
	}

	public Planeta getSol() {
		return sol;
	}

	public void setSol(Planeta sol) {
		this.sol = sol;
	}
	public int getNroDia() {
		return nroDia;
	}
	public void setNroDia(int nroDia) {
		this.nroDia = nroDia;
	}

	public EstadoSistemaSolar getEstado() {
		return estado;
	}

	public void setEstado(EstadoSistemaSolar estado) {
		this.estado = estado;
	}

	public void actualizarEstado() {

		long intensidad = 1;
		Recta recta = new Recta();
		Periodo periodo = Periodo.NINGUNO;
		
		Point2D punto1 = this.getBetasoide().getPunto();
		Point2D punto2 = this.getFerengi().getPunto();
		recta.setLinea(punto1, punto2);
	
		if (recta.contiene(this.getVulcano().getPunto())) {
			periodo = Periodo.OPTIMO;
			if (recta.contiene(this.getSol().getPunto())) {
				periodo = Periodo.SEQUIA;
			}
		} else {
			Triangulo2D triangulo = new Triangulo2D(
							this.getBetasoide().getPunto(),
							this.getFerengi().getPunto(),
							this.getVulcano().getPunto());
			
			if (triangulo.contiene(this.getSol().getPunto())) {
				periodo = Periodo.LLUVIOSO;
				intensidad = Math.round(triangulo.calcularArea());
			}
		}
		this.estado = new EstadoSistemaSolar(this.nroDia, periodo, intensidad);
	}
	
	

	public void sumarCantidadDias(int nroDias) {
		this.getBetasoide().avanzar(nroDias);
		this.getVulcano().avanzar(nroDias);
		this.getFerengi().avanzar(nroDias);
		this.nroDia += nroDias;
	}

	public void avanzarUnDia() {
		this.sumarCantidadDias(1);
		this.actualizarEstado();
	}
}
