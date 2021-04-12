package com.bew.demo.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlumnoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long idAlumno;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private Integer boleta;
	private String programaAcademico;
	private String sexo;
	private Long idUsuario;

}
