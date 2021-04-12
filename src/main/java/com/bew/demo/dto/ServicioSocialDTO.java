package com.bew.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class ServicioSocialDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long idServicio;
	private String semestre;
	private String responsableDirecto;
	private String estado;
	private String fechaRegistro;
	private String revisado;
	private Long idAlumno;
	
}
