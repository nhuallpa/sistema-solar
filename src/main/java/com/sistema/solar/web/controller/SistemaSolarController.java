package com.sistema.solar.web.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.solar.modelo.EstadoSistemaSolar;
import com.sistema.solar.web.dao.SistemaSolarRepository;
import com.sistema.solar.web.dto.ClimaDto;

@RestController
public class SistemaSolarController {
	
	@Autowired
	private SistemaSolarRepository sistemaSolarRepository;
	
	@GetMapping(name = "/clima")
	public ClimaDto consultarClima(@RequestParam Long dia) {
		Optional<EstadoSistemaSolar> estado = sistemaSolarRepository.findById(dia);
		return new ClimaDto(estado.get());
	}
}
