package com.sistema.solar.web.service;

import com.sistema.solar.web.dto.ClimaDto;
import com.sistema.solar.web.dto.InformeDto;

public interface SistemaSolarService {

	public ClimaDto consultarClima(Long dia);

	public InformeDto consultarInforme();
	
}
