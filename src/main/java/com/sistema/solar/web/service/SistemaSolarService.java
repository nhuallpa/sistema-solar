package com.sistema.solar.web.service;

import com.sistema.solar.web.dto.ClimaDto;
import com.sistema.solar.web.dto.InformeDto;

public interface SistemaSolarService {

	/**
	 * Consulta el clima para un dia especifico.
	 * @param dia
	 * @return ClimaDto
	 */
	public ClimaDto consultarClima(Long dia);

	
	/***
	 * Informe del clima 
	 * @return InformeDto
	 */
	public InformeDto consultarInforme();
	
}
