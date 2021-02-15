package com.bew.demo.dao;

import org.springframework.stereotype.Repository;

import com.bew.demo.model.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario,Integer>{

	@Query(
            value = "SELECT s FROM Usuario s WHERE s.email = :email",
            nativeQuery = false)
    Optional<Usuario> findByEmail(@Param("email") String email);
	
	@Query(
            value = "SELECT s FROM Usuario s WHERE s.contraseña = :contraseña",
            nativeQuery = false)
    Optional<Usuario> findByContraseña(@Param("contraseña") String contraseña);
	
	@Query(
            value = "SELECT s FROM Usuario s WHERE s.tipoUsuario = :tipoUsuario",
            nativeQuery = false)
    Optional<Usuario> findByTipo(@Param("tipoUsuario") Boolean tipoUsuario);
}
