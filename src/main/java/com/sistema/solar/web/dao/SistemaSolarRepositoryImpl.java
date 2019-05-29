package com.sistema.solar.web.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sistema.solar.modelo.EstadoSistemaSolar;
import com.sistema.solar.modelo.Periodo;

@Repository
@Transactional(readOnly = true)
public class SistemaSolarRepositoryImpl implements SistemaSolarRepositoryCustom {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public Integer consultarCantidadPeriodos(Periodo periodo) {
		Query query = em.createNativeQuery("SELECT COUNT(*) FROM sistema_solar WHERE periodo = :periodo");
        query.setParameter("periodo", periodo.name());
		return ((Number)query.getSingleResult()).intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EstadoSistemaSolar> consultarDiasLluviaIntenso() {
		Query query = em.createNativeQuery("SELECT s.* FROM sistema_solar s WHERE s.intensidad = "
				+ "(SELECT MAX(ss.intensidad) FROM sistema_solar ss where ss.periodo = :periodo )", EstadoSistemaSolar.class);
		query.setParameter("periodo", Periodo.LLUVIOSO.name());
		List<EstadoSistemaSolar> resultList = query.getResultList();
		return resultList;
	}

}
