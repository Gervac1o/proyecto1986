package com.bew.demo.dao;

import java.util.Optional;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bew.demo.model.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository <Alumno,Integer>{

}
