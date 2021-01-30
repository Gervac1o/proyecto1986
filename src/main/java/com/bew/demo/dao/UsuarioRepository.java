package com.bew.demo.dao;

import org.springframework.stereotype.Repository;

import com.bew.demo.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario,Integer>{

}
