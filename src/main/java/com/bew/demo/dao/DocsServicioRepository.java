package com.bew.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bew.demo.model.DocsServicio;

@Repository
public interface DocsServicioRepository extends JpaRepository <DocsServicio, Integer> {

}
