package com.bew.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="lista_docs")
public class ListaDocs implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "lista_sec", sequenceName = "lista_seq", allocationSize = 1, initialValue=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lista_sec")
	@Column(name="id_lista")
	private Integer idLista;
	
	@Column(name="nombre_doc")
	private String nombreDoc;
	
	@Column(name="id_doc")
	private String idDoc;

	
	@Column(name="comentario")
	private String comentario;
	
	@Column(name="id_alumno")
	private Integer idAlumno;
	
	@Column(name = "id_tramite")
	private Integer idTramite;


	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_alumno",insertable=false, updatable = false)
	private Alumno alumno;

	
	
	public ListaDocs() {};
	
	public ListaDocs(Integer idLista, String nombreDoc, String idDoc, String comentario, Integer idTramite) {

		super();
		this.idLista = idLista;
		this.nombreDoc = nombreDoc;
		this.idDoc = idDoc;
		this.idTramite=idTramite;
		this.comentario = comentario;
		
	}

	public Integer getIdLista() {
		return idLista;
	}

	public void setIdLista(Integer idLista) {
		this.idLista = idLista;
	}

	public String getNombreDoc() {
		return nombreDoc;
	}

	public Integer getIdTramite() {
		return idTramite;
	}

	public void setIdTramite(Integer idTramite) {
		this.idTramite = idTramite;
	}

	public void setNombreDoc(String nombreDoc) {
		this.nombreDoc = nombreDoc;
	}




	public String getIdDoc() {
		return idDoc;
	}

	public void setIdDoc(String idDoc) {

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

}
	
	
	
	
	

