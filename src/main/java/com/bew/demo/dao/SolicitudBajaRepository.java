package com.bew.demo.dao;

import org.springframework.stereotype.Repository;

import com.bew.demo.model.SolicitudBaja;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SolicitudBajaRepository extends JpaRepository <SolicitudBaja,Integer>{

}
