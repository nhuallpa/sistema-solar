package com.sistema.solar.batch;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.sistema.solar.modelo.EstadoSistemaSolar;
import com.sistema.solar.modelo.Planeta;
import com.sistema.solar.modelo.Sentido;
import com.sistema.solar.modelo.SistemaSolar;

public class SistemaSolarItemReader implements ItemReader<EstadoSistemaSolar>{

	private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

	
	private int indiceSiguienteEstado;
	private SistemaSolar sistemaSolar;
	private static int CANT_ANIOS = 10;
	private List<EstadoSistemaSolar> estadosSistemaSolar;
	
	public SistemaSolarItemReader() {
		this.inicializar();
	}
	
	private void inicializar() {
		this.estadosSistemaSolar = new ArrayList<EstadoSistemaSolar>();
		
		Planeta ferengi = new Planeta(90, 1 , 500, Sentido.HORARIO);
		Planeta betasoide = new Planeta(90, 3, 2000, Sentido.HORARIO);
		Planeta vulcano = new Planeta(90, 5, 1000, Sentido.ANTIHORARIO);
		Planeta sol = new Planeta(0, 0, 0, Sentido.ANTIHORARIO);
		
		this.sistemaSolar = new SistemaSolar(sol, ferengi, betasoide, vulcano);
		
		for (int dia = 0; dia < CANT_ANIOS*365; dia++) {
			this.sistemaSolar.avanzarUnDia();
			this.estadosSistemaSolar.add(this.sistemaSolar.getEstado());
		}
		this.indiceSiguienteEstado = 0;
	}

	@Override
	public EstadoSistemaSolar read()
			throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

		EstadoSistemaSolar estado = null;
		if (this.indiceSiguienteEstado < this.estadosSistemaSolar.size()) {
			estado = this.estadosSistemaSolar.get(this.indiceSiguienteEstado);
			this.indiceSiguienteEstado++;
			if (estado != null) {
				log.info(estado.toString());	
			}
		}
		return estado;
	}
}
