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
	private Long idAlumno;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido_paterno")
	private String apellidoPaterno;
	
	@Column(name="apellido_materno")
	private String apellidoMaterno;
	
	@Column(name="boleta")
	private String boleta;
	
	@Column(name="programa_academico")
	private String programaAcademico;
	
	@Column(name="sexo")
	private String sexo;
	
	@Column(name="id_usuario")
	private Long idUsuario;
	

	
	public Alumno() {}
	public Alumno( Long idAlumno, String nombre, String apellidoPaterno, String apellidoMaterno,
			String boleta, String programaAcademico, String sexo, Long idUsuario) {
		
		
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

	
}
