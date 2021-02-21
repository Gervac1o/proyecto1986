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
@Table(name="servicio_social")
public class ServicioSocial implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_servicio")
	private Integer idServicio;

	@Column(name="semestre")
	private String semestre;

	@Column(name="responsable_directo")
	private String responsableDirecto;
	
	@Column(name="estado")
	private String estado;
	
	@Column(name="id_alumno")
	private Integer idAlumno;

	public ServicioSocial() {}
	public ServicioSocial( Integer idServicio, String semestre, String responsableDirecto, String estado, Integer idAlumno) {

		this.idServicio=idServicio;
		this.semestre=semestre;
		this.responsableDirecto=responsableDirecto;
		this.estado=estado;
		this.idAlumno=idAlumno;
}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_alumno",insertable=false, updatable = false)
	private Alumno alumno;

	public Integer getIdServicio() {
		return idServicio;
	}
	public void setIdServicio(Integer idServicio) {
		this.idServicio = idServicio;
	}
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	public String getResponsableDirecto() {
		return responsableDirecto;
	}
	public void setResponsableDirecto(String responsableDirecto) {
		this.responsableDirecto = responsableDirecto;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}
	
}
