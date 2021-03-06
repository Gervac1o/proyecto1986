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
	private Integer idDictamen;
	
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
	private Integer idAlumno;
	
	public Dictamen () {}
	
	public Dictamen (Integer idDictamen , Long porcentajeCreditos ,String semestre, String estado,String fechaRegistro,
			String revisado, Integer idAlumno) {
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

	public Long getPorcentajeCreditos() {
		return porcentajeCreditos;
	}

	public void setPorcentajeCreditos(Long porcentajeCreditos) {
		this.porcentajeCreditos = porcentajeCreditos;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public Integer getIdDictamen() {
		return idDictamen;
	}

	public void setIdDictamen(Integer idDictamen) {
		this.idDictamen = idDictamen;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getRevisado() {
		return revisado;
	}

	public void setRevisado(String revisado) {
		this.revisado = revisado;
	}

	public Integer getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}
	
}
