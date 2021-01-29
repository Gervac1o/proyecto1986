package com.bew.demo.dto;

import java.io.Serializable;

public class ServicioSocialDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idServicio;
	private String programaAcademico;
	private Integer semestre;
	private String responsableDirecto;
	private Integer idAlumno;
	
	public Integer getIdServicio() {
		return idServicio;
	}
	public void setIdServicio(Integer idServicio) {
		this.idServicio = idServicio;
	}
	public String getProgramaAcademico() {
		return programaAcademico;
	}
	public void setProgramaAcademico(String programaAcademico) {
		this.programaAcademico = programaAcademico;
	}
	public Integer getSemestre() {
		return semestre;
	}
	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}
	public String getResponsableDirecto() {
		return responsableDirecto;
	}
	public void setResponsableDirecto(String responsableDirecto) {
		this.responsableDirecto = responsableDirecto;
	}
	public Integer getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}
	
}
