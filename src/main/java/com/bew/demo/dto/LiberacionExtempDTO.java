package com.bew.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class LiberacionExtempDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer idLiberacion;
	private String semestre;
	private Boolean egresado;
	private String registroSS;
	private String prestatario;
	private String programaSS;
	private String fechaInicio;
	private String fechaTermino;
	private String telefono;
	private String estado;
	private String fechaRegistro;
	private String revisado;
	private Integer idAlumno;

}
