package com.bew.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bew.demo.model.ListaDocs;
@Repository
public interface ListaDocsDAO extends JpaRepository<ListaDocs, Integer > {

}

