package com.bew.demo.dto;

import java.io.Serializable;

public class ServicioSocialDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idServicio;
	private String semestre;
	private String responsableDirecto;
	private String estado;
	private String fechaRegistro;
	private String revisado;
	private Integer idAlumno;
	
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
