package com.bew.demo.dao;

import org.springframework.stereotype.Repository;

import com.bew.demo.model.ServicioSocial;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface ServicioSocialRepository extends JpaRepository <ServicioSocial,Integer> {
	
	@Query(
            value = "SELECT s FROM ServicioSocial s WHERE s.idAlumno = :idAlumno",
            nativeQuery = false)
    Optional<ServicioSocial> findByIdAlumno(@Param("idAlumno") Integer idAlumno);

}
