package com.bew.demo.dto;

import java.io.Serializable;

public class DictamenDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long porcentajeCreditos;
	private Integer semestre;
	private String programaAcademico;
	private String sexo;
	private Integer idDictamen;
	private Integer idAlumno;
	

	public Long getPorcentajeCreditos() {
		return porcentajeCreditos;
	}

	public void setPorcentajeCreditos(Long porcentajeCreditos) {
		this.porcentajeCreditos = porcentajeCreditos;
	}

	public Integer getSemestre() {
		return semestre;
	}

	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}

	public String getProgramaAcademico() {
		return programaAcademico;
	}

	public void setProgramaAcademico(String programaAcademico) {
		this.programaAcademico = programaAcademico;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Integer getIdDictamen() {
		return idDictamen;
	}

	public void setIdDictamen(Integer idDictamen) {
		this.idDictamen = idDictamen;
	}

	public Integer getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}

}
