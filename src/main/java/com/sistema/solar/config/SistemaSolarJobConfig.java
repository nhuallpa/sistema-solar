package com.sistema.solar.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sistema.solar.batch.JobCompletionNotificationListener;
import com.sistema.solar.batch.SistemaSolarItemProcessor;
import com.sistema.solar.batch.SistemaSolarItemReader;
import com.sistema.solar.modelo.EstadoSistemaSolar;

@Configuration
@EnableBatchProcessing
public class SistemaSolarJobConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public ItemReader<EstadoSistemaSolar> enMemoriaSistemaSolar() {
		return new SistemaSolarItemReader();
	}
	
	@Bean
	public SistemaSolarItemProcessor processor() {
		return new SistemaSolarItemProcessor();
	}
	
	@Bean
	public JdbcBatchItemWriter<EstadoSistemaSolar> writer(DataSource dataSource) {
		return new JdbcBatchItemWriterBuilder<EstadoSistemaSolar>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
	            .sql("INSERT INTO sistema_solar (dia, periodo, intensidad) VALUES (:nroDia, :periodo, :intensidad)")
	            .dataSource(dataSource)
	            .build();
	}
	
	@Bean
	public Job importSistemaSolarJob(JobCompletionNotificationListener listener, Step step1) {
		
		return jobBuilderFactory.get("importSistemaSolar")
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.flow(step1)
				.end()
				.build();
	}
	@Bean
	public Step step1(JdbcBatchItemWriter<EstadoSistemaSolar> writer) {
		return stepBuilderFactory.get("step1")
				.<EstadoSistemaSolar, EstadoSistemaSolar> chunk(10)
				.reader(enMemoriaSistemaSolar())
				.processor(processor()) 
				.writer(writer)
				.build();
	}
	
}
