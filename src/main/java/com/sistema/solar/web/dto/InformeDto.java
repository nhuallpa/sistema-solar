package com.sistema.solar.web.dto;

import java.util.List;

import com.sistema.solar.modelo.EstadoSistemaSolar;

/**
 * @author nestor
 *
 */
public class InformeDto {

	private int periodosSequia;
	private int periodosLluvia;
	private int periodosOptimos;
	private List<EstadoSistemaSolar> diasDeLluviaIntensa;
	
	public int getPeriodosSequia() {
		return periodosSequia;
	}
	public void setPeriodosSequia(int periodosSequia) {
		this.periodosSequia = periodosSequia;
	}
	public int getPeriodosLluvia() {
		return periodosLluvia;
	}
	public void setPeriodosLluvia(int periodosLluvia) {
		this.periodosLluvia = periodosLluvia;
	}
	public int getPeriodosOptimos() {
		return periodosOptimos;
	}
	public void setPeriodosOptimos(int periodosOptimos) {
		this.periodosOptimos = periodosOptimos;
	}
	public List<EstadoSistemaSolar> getDiasDeLluviaIntensa() {
		return diasDeLluviaIntensa;
	}
	public void setDiasDeLluviaIntensa(List<EstadoSistemaSolar> diasDeLluviaIntensa) {
		this.diasDeLluviaIntensa = diasDeLluviaIntensa;
	}
	
}
