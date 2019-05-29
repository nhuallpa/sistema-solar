package com.sistema.solar.web.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

	@Override
	public Integer consultarDiaLluviaIntenso() {
		// TODO Auto-generated method stub
		return null;
	}

}
