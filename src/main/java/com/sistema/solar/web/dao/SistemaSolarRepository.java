package com.sistema.solar.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.solar.modelo.EstadoSistemaSolar;

@Repository
public interface SistemaSolarRepository extends JpaRepository<EstadoSistemaSolar, Long>, SistemaSolarRepositoryCustom{

}
