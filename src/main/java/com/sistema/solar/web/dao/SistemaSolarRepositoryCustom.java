package com.sistema.solar.web.dao;

import com.sistema.solar.modelo.Periodo;

public interface SistemaSolarRepositoryCustom {

	public Integer consultarCantidadPeriodos(Periodo periodo);
	
	public Integer consultarDiaLluviaIntenso(); 
}
