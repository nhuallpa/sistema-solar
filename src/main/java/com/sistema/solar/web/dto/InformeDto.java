package com.sistema.solar.web.dto;

public class InformeDto {

	private int periodosSequia;
	private int periodosLluvia;
	private int diaDeLluviaIntensa;
	private int periodosOptimos;
	
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
	public int getDiaDeLluviaIntensa() {
		return diaDeLluviaIntensa;
	}
	public void setDiaDeLluviaIntensa(int diaDeLluviaIntensa) {
		this.diaDeLluviaIntensa = diaDeLluviaIntensa;
	}
	public int getPeriodosOptimos() {
		return periodosOptimos;
	}
	public void setPeriodosOptimos(int periodosOptimos) {
		this.periodosOptimos = periodosOptimos;
	}
	
}
