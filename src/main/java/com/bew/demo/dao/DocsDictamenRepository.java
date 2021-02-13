package com.bew.demo.dao;


//import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.http.ResponseEntity;

import com.bew.demo.model.DocsDictamen;

public interface DocsDictamenRepository extends JpaRepository <DocsDictamen,Integer>{
	
	@Query(
            value = "SELECT s FROM DocsDictamen s WHERE s.idDoc = :idDoc",
            nativeQuery = false)
	DocsDictamen findDoc(@Param("idDoc") String idDoc);

}
