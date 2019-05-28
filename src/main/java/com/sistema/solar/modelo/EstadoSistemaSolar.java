package com.sistema.solar.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sistema_solar")
public class EstadoSistemaSolar {

	@Id
	@Column(name = "dia")
	private long nroDia;
	
	private String periodo;
	private long intensidad;
	
	public EstadoSistemaSolar() {
		super();
	}
	
	public EstadoSistemaSolar(long nroDia, Periodo periodo, long intencidad) {
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

	public long getNroDia() {
		return nroDia;
	}
	public void setNroDia(long nroDia) {
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
