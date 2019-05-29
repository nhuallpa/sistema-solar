package com.sistema.solar.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.sistema.solar.modelo.EstadoSistemaSolar;
import com.sistema.solar.modelo.Periodo;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

	private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
			log.info("!!! JOB Terminado: Resultado:");

			jdbcTemplate.query("SELECT dia, periodo, intensidad FROM sistema_solar",
				(rs, row) -> new EstadoSistemaSolar(
					Integer.valueOf(rs.getString(1)),
					Periodo.valueOf(rs.getString(2)),
					Long.valueOf(rs.getString(3)))
			).forEach(estado -> log.info("Registro  <" + estado + "> en la base de datos."));
		}
	}
	
}
