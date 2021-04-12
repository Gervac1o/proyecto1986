package com.bew.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name="dictamen")
public class Dictamen implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_dictamen")
	private Long idDictamen;
	
	@Column(name = "porcentaje_creditos")
	private Long porcentajeCreditos;
	
	@Column(name = "semestre")
	private String semestre;
	
	@Column(name="estado")
	private String estado;
	
	@Column(name="fecha_registro")
	private String fechaRegistro;
	
	@Column(name="revisado")
	private String revisado;
	
	@Column(name="id_alumno")
	private Long idAlumno;
	
	public Dictamen () {}
	
	public Dictamen (Long idDictamen , Long porcentajeCreditos ,String semestre, String estado,String fechaRegistro,
			String revisado, Long idAlumno) {
		this.idDictamen=idDictamen;
		this.porcentajeCreditos=porcentajeCreditos;
		this.semestre=semestre;
		this.estado=estado;
		this.fechaRegistro=fechaRegistro;
		this.revisado=revisado;
		this.idAlumno=idAlumno;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_alumno",insertable=false, updatable = false)
	private Alumno alumno;




}
