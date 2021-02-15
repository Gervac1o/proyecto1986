package com.bew.demo.dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bew.demo.model.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository <Alumno,Integer>{

	@Query(
            value = "SELECT s FROM Alumno s WHERE s.nombre = :nombre",
            nativeQuery = false)
    Optional<Alumno> findByNombre(@Param("nombre") String nombre);
	
	@Query(
            value = "SELECT s FROM Alumno s WHERE s.apellidoPaterno = :apellidoPaterno",
            nativeQuery = false)
    Optional<Alumno> findByApellidoPaterno(@Param("apellidoPaterno") String apellidoPaterno);
	
	@Query(
            value = "SELECT s FROM Alumno s WHERE s.apellidoMaterno = :apellidoMaterno",
            nativeQuery = false)
    Optional<Alumno> findByApellidoMaterno(@Param("apellidoMaterno") String apellidoMaterno);
	
	@Query(
            value = "SELECT s FROM Alumno s WHERE s.boleta = :boleta",
            nativeQuery = false)
    Optional<Alumno> findByBoleta(@Param("boleta") Integer boleta);
	@Query(
            value = "SELECT s FROM Alumno s WHERE s.idUsuario = :idUsuario",
            nativeQuery = false)
    Optional<Alumno> findByIdUsuario(@Param("idUsuario") Integer idUsuario);
}
