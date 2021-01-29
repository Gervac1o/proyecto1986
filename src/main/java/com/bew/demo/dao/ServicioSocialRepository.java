package com.bew.demo.dao;

import org.springframework.stereotype.Repository;

import com.bew.demo.model.ServicioSocial;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ServicioSocialRepository extends JpaRepository <ServicioSocial,Integer> {

}
