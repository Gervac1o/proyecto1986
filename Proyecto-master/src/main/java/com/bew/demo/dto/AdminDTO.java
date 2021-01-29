package com.bew.demo.dto;

import java.io.Serializable;

public class AdminDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer idAdmin;
	private String nombre;
	private String apellidos;
	private Integer telefono;
	
	public Integer getIdAdmin() {
		return idAdmin;
	}
	public void setIdAdmin(Integer idAdmin) {
		this.idAdmin = idAdmin;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

}
