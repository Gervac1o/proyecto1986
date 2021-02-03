package com.bew.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bew.demo.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente,Integer>{

    @Query(
            value = "SELECT s FROM Cliente s WHERE s.nombre = :nombre",
            nativeQuery = false)
    Optional<Cliente> findByNombre(@Param("nombre") String nombre);	
}
