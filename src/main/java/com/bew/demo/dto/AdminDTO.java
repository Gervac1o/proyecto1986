package com.bew.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AdminDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long idAdmin;
	private String nombre;
	private String apellidos;
	private String telefono;
	private Long idUsuario;

}
