package com.bew.demo.dao;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

import com.bew.demo.model.DocsBaja;

public interface DocsBajaRepository extends JpaRepository<DocsBaja, Integer> {
	
	/*@Query(
            value = "SELECT s FROM DocsBaja s WHERE s.idSolicitud = :idSolicitud",
            nativeQuery = false)
    Optional<DocsBaja> findByIdSolicitud(@Param("idSolicitud") Integer idSolicitud);*/

}
