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
@Table(name="alumno")
public class Alumno implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "alumno_sec", sequenceName = "alumno_seq", allocationSize = 1, initialValue=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alumno_sec")
	@Column(name="id_alumno")
	private Integer idAlumno;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido_paterno")
	private String apellidoPaterno;
	
	@Column(name="apellido_materno")
	private String apellidoMaterno;
	
	@Column(name="boleta")
	private Integer boleta;
	
	@Column(name="programa_academico")
	private String programaAcademico;
	
	@Column(name="sexo")
	private String sexo;
	
	@Column(name="id_usuario")
	private Integer idUsuario;
	

	
	public Alumno() {}
	public Alumno( Integer idAlumno, String nombre, String apellidoPaterno, String apellidoMaterno, 
			Integer boleta, String programaAcademico, String sexo, Integer idUsuario) {
		
		
		this.nombre=nombre;	
		this.idAlumno=idAlumno;
		this.apellidoPaterno=apellidoPaterno;
		this.apellidoMaterno=apellidoMaterno;
		this.boleta=boleta;
		this.programaAcademico = programaAcademico;
		this.sexo = sexo;
		this.idUsuario=idUsuario;
	
}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario",insertable=false, updatable = false)
	private Usuario usuario;
	
	public Integer getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	
	public Integer getBoleta() {
		return boleta;
	}
	
	public void setBoleta(Integer boleta) {
		this.boleta = boleta;
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
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	
}
