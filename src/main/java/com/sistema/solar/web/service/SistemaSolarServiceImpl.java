package com.sistema.solar.web.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.solar.modelo.EstadoSistemaSolar;
import com.sistema.solar.modelo.Periodo;
import com.sistema.solar.web.dao.SistemaSolarRepository;
import com.sistema.solar.web.dto.ClimaDto;
import com.sistema.solar.web.dto.InformeDto;
import com.sistema.solar.web.exception.NoEncontradoException;

@Service
public class SistemaSolarServiceImpl implements SistemaSolarService {

	@Autowired
	private SistemaSolarRepository sistemaSolarRepository;
	
	@Override
	public ClimaDto consultarClima(Long dia) {
		Optional<EstadoSistemaSolar> estado = sistemaSolarRepository.findById(dia);
		if (!estado.isPresent()) {
			throw new NoEncontradoException("Estado del clima no encontrado");
		}
		return new ClimaDto(estado.get());
	}

	@Override
	public InformeDto consultarInforme() {
		InformeDto informe = new InformeDto();
		informe.setPeriodosSequia(sistemaSolarRepository.consultarCantidadPeriodos(Periodo.SEQUIA));
		informe.setPeriodosLluvia(sistemaSolarRepository.consultarCantidadPeriodos(Periodo.LLUVIOSO));
		informe.setPeriodosOptimos(sistemaSolarRepository.consultarCantidadPeriodos(Periodo.OPTIMO));
		return informe;
	}

}
