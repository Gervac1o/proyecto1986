package com.bew.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bew.demo.model.DocsLiberacion;

public interface DocsLiberacionExtempRepository extends JpaRepository<DocsLiberacion, Integer> {
	
	@Query(
            value = "SELECT s FROM DocsLiberacion s WHERE s.idDoc = :idDoc",
            nativeQuery = false)
	DocsLiberacion findDoc(@Param("idDoc") String idDoc);

}
