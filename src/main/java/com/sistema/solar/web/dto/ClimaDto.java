package com.sistema.solar.web.dto;

import com.sistema.solar.modelo.EstadoSistemaSolar;

public class ClimaDto {

	private long dia;
	private String clima;
	
	public ClimaDto(int dia, String clima) {
		super();
		this.dia = dia;
		this.clima = clima;
	}
	public ClimaDto(EstadoSistemaSolar estadoSistemaSolar) {
		this.dia = estadoSistemaSolar.getNroDia();
		this.clima = estadoSistemaSolar.getPeriodo();
	}
	
	public long getDia() {
		return dia;
	}
	public void setDia(long dia) {
		this.dia = dia;
	}
	public String getClima() {
		return clima;
	}
	public void setClima(String clima) {
		this.clima = clima;
	}
	
	
}
