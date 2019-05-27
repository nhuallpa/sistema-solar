package com.sistema.solar.batch;

import org.springframework.batch.item.ItemProcessor;

import com.sistema.solar.modelo.EstadoSistemaSolar;

public class SistemaSolarItemProcessor 
		implements ItemProcessor<EstadoSistemaSolar, EstadoSistemaSolar>{

	@Override
	public EstadoSistemaSolar process(EstadoSistemaSolar item) throws Exception {
		return item;
	}
	
}
