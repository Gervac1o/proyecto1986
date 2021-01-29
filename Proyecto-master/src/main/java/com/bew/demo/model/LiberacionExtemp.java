package com.bew.demo.model;

import java.io.Serializable;
//import java.sql.Date;
import java.util.Date;

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
@Table(name="liberacion_extemporanea")
public class LiberacionExtemp implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "liberacion_sec", sequenceName = "liberacion_seq", allocationSize = 1, initialValue=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "liberacion_sec")
	@Column(name="id_liberacion")
	private Integer idLiberacion;

	@Column(name="programa_academico")
	private String programaAcademico;

	@Column(name="semestre")
	private Integer semestre;

	@Column(name="egresado")
	private Boolean egresado;

	@Column(name="registro_ss")
	private String registroSS;
	
	@Column(name="prestatario")
	private String prestatario;

	@Column(name="programa_ss")
	private String programaSS;

	@Column(name="fecha_inicio")
	private Date fechaInicio;

	@Column(name="fecha_termino")
	private Date fechaTermino;
	
	@Column(name="telefono")
	private Integer telefono;

	@Column(name="sexo")
	private String sexo;
	
	@Column(name="id_alumno")
	private Integer idAlumno;

	public Integer getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}
	public LiberacionExtemp() {}
	public LiberacionExtemp( Integer idLiberacion, String programaAcademico, Integer semestre, Boolean egresado, String registroSS, 
	String prestatario, String programaSS, Date fechaInicio, Date fechaTermino, Integer telefono, String sexo,Integer idAlumno) {

		this.idLiberacion=idLiberacion;
		this.programaAcademico=programaAcademico;
		this.semestre=semestre;
		this.egresado=egresado;
		this.registroSS=registroSS;
		this.prestatario=prestatario;
		this.programaSS=programaSS;
		this.fechaInicio=fechaInicio;
		this.fechaTermino=fechaTermino;
		this.telefono=telefono;
		this.sexo=sexo;
		this.idAlumno=idAlumno;
}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_alumno",insertable=false, updatable = false)
	private Alumno alumno;

	public Integer getIdLiberacion() {
		return idLiberacion;
	}
	public void setIdLiberacion(Integer idLiberacion) {
		this.idLiberacion = idLiberacion;
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
	public Boolean getEgresado() {
		return egresado;
	}
	public void setEgresado(Boolean egresado) {
		this.egresado = egresado;
	}
	public String getRegistroSS() {
		return registroSS;
	}
	public void setRegistroSS(String registroSS) {
		this.registroSS = registroSS;
	}
	public String getPrestatario() {
		return prestatario;
	}
	public void setPrestatario(String prestatario) {
		this.prestatario = prestatario;
	}
	public String getProgramaSS() {
		return programaSS;
	}
	public void setProgramaSS(String programaSS) {
		this.programaSS = programaSS;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaTermino() {
		return fechaTermino;
	}
	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
}
