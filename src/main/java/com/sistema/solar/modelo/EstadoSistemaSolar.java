package com.sistema.solar.modelo;

public class EstadoSistemaSolar {

	private int nroDia;
	private String periodo;
	private long intensidad;
	
	public EstadoSistemaSolar(int nroDia, Periodo periodo, long intencidad) {
		super();
		this.nroDia = nroDia;
		this.periodo = periodo.name();
		this.intensidad = intencidad;
	}
	
	public long getIntensidad() {
		return intensidad;
	}

	public void setIntensidad(long intensidad) {
		this.intensidad = intensidad;
	}

	public int getNroDia() {
		return nroDia;
	}
	public void setNroDia(int nroDia) {
		this.nroDia = nroDia;
	}
	
	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	@Override
	public String toString() {
		return "EstadoSistemaSolar [nroDia=" + nroDia + ", periodo=" + periodo + ", intensidad=" + intensidad + "]";
	}

}
