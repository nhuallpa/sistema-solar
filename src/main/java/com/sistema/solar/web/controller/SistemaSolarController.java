package com.sistema.solar.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.solar.web.dto.ClimaDto;
import com.sistema.solar.web.dto.InformeDto;
import com.sistema.solar.web.service.SistemaSolarService;

@RestController
public class SistemaSolarController {
	
	@Autowired
	private SistemaSolarService sistemaSolarService;
	
	@RequestMapping(value = "/clima", method = RequestMethod.GET)
	public ClimaDto consultarClima(@RequestParam Long dia) {
		return sistemaSolarService.consultarClima(dia);
	}
	
	@RequestMapping(value = "/informe", method = RequestMethod.GET)
	public InformeDto consultarInfome() {
		return sistemaSolarService.consultarInforme();
	}
	
}
