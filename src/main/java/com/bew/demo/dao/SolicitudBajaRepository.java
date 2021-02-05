package com.bew.demo.dao;

import org.springframework.stereotype.Repository;

import com.bew.demo.model.SolicitudBaja;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface SolicitudBajaRepository extends JpaRepository <SolicitudBaja,Integer>{
	
	@Query(
            value = "SELECT s FROM SolicitudBaja s WHERE s.idAlumno = :idAlumno",
            nativeQuery = false)
    Optional<SolicitudBaja> findByIdAlumno(@Param("idAlumno") Integer idAlumno);

}
