package com.bew.demo.dto;

import java.io.Serializable;
public class ListaDocsDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private Integer idLista;
	private String nombreDoc;
	private Integer idDoc;
	private String comentario;
	private Integer idAlumno;
	private Integer idTtramie;
	public Integer getIdLista() {
		return idLista;
	}
	public void setIdLista(Integer idLista) {
		this.idLista = idLista;
	}
	public String getNombreDoc() {
		return nombreDoc;
	}
	public void setNombreDoc(String nombreDoc) {
		this.nombreDoc = nombreDoc;
	}
	public Integer getIdDoc() {
		return idDoc;
	}
	public void setIdDoc(Integer idDoc) {
		this.idDoc = idDoc;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Integer getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}
	public Integer getIdTtramie() {
		return idTtramie;
	}
	public void setIdTtramie(Integer idTtramie) {
		this.idTtramie = idTtramie;
	}
	
	
	
}
