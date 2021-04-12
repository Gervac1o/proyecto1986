package com.bew.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class DictamenDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long porcentajeCreditos;
	private String semestre;
	private Long idDictamen;
	private String estado;
	private String fechaRegistro;
	private String revisado;
	private Long idAlumno;


}
