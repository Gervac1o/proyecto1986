package com.bew.demo.dao;

import org.springframework.stereotype.Repository;

import com.bew.demo.model.LiberacionExtemp;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
@Repository
public interface LiberacionExtempRepository extends JpaRepository <LiberacionExtemp,Integer>{
	
	@Query(
            value = "SELECT s FROM LiberacionExtemp s WHERE s.idAlumno = :idAlumno",
            nativeQuery = false)
    Optional<LiberacionExtemp> findByIdAlumno(@Param("idAlumno") Integer idAlumno);

}
