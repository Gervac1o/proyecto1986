package com.bew.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class SolicitudBajaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long idSolicitud;
	private String tipoDeBaja;
	private Integer horas;
	private String semestre;
	private Boolean egresado;
	private String registroSS;
	private String prestatario;
	private String programaSS;
	private String fechaInicio;
	private String fechaTermino;
	private String estado;
	private String fechaRegistro;
	private String revisado;
	private Long idAlumno;
	
}
