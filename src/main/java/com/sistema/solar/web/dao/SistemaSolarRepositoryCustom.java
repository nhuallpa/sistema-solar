package com.sistema.solar.web.dao;

import java.util.List;

import com.sistema.solar.modelo.EstadoSistemaSolar;
import com.sistema.solar.modelo.Periodo;

/***
 * Consultas personalizadas para el Clima
 * @author nestor
 *
 */
public interface SistemaSolarRepositoryCustom {

	public Integer consultarCantidadPeriodos(Periodo periodo);
	
	public List<EstadoSistemaSolar> consultarDiasLluviaIntenso();
}
