package com.bew.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bew.demo.model.ListaDocs;

public interface ListaDocsRepository extends JpaRepository<ListaDocs,Integer> {

}
