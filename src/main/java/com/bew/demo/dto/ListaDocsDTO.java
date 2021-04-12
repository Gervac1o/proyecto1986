package com.bew.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ListaDocsDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	

	private Long idLista;
	private String nombreDoc;
	private String idDoc;
	private String comentario;
	private Integer idAlumno;
	private Long idTramite;
	
	
}