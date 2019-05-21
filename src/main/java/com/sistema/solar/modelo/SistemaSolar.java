package com.sistema.solar.modelo;

import java.awt.geom.Point2D;

import com.sistema.solar.math.Recta;
import com.sistema.solar.math.Triangulo2D;

public class SistemaSolar {

	private Planeta sol;
	private Planeta ferengi;
	private Planeta betasoide;
	private Planeta vulcano;
	
	public SistemaSolar(Planeta sol, Planeta ferengi, Planeta betasoide, Planeta vulcano) {
		super();
		this.sol = sol;
		this.ferengi = ferengi;
		this.betasoide = betasoide;
		this.vulcano = vulcano;
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


	public Periodo getPeriodo() {

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
				return Periodo.LLUVIOSO;
			}
		}
		return periodo;
	}

	public void sumarCantidadDias(int nroDias) {
		this.getBetasoide().avanzar(nroDias);
		this.getVulcano().avanzar(nroDias);
		this.getFerengi().avanzar(nroDias);
	}
}
