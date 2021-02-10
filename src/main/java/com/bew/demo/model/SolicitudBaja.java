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
@Table(name="solicitud_baja")
public class SolicitudBaja implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "solicitud_sec", sequenceName = "solicitud_seq", allocationSize = 1, initialValue=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "solicitud_sec")
	@Column(name="id_solicitud")
	private Integer idSolicitud;
	
	@Column(name="tipo_de_baja")
	private String tipoDeBaja;

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
	
	@Column(name="id_alumno")
	private Integer idAlumno;
	
	public SolicitudBaja() {}
	public SolicitudBaja( Integer idSolicitud, String tipoDeBaja, Integer semestre, Boolean egresado, String registroSS, 
	String prestatario, String programaSS, Date fechaInicio, Date fechaTermino, Integer idAlumno) {

		this.idSolicitud=idSolicitud;
		this.tipoDeBaja=tipoDeBaja;
		this.semestre=semestre;
		this.egresado=egresado;
		this.registroSS=registroSS;
		this.prestatario=prestatario;
		this.programaSS=programaSS;
		this.fechaInicio=fechaInicio;
		this.fechaTermino=fechaTermino;
		this.idAlumno=idAlumno;
}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_alumno",insertable=false, updatable = false)
	private Alumno alumno;

	public Integer getIdSolicitud() {
		return idSolicitud;
	}
	public void setIdSolicitud(Integer idSolicitud) {
		this.idSolicitud = idSolicitud;
	}
	public String getTipoDeBaja() {
		return tipoDeBaja;
	}
	public void setTipoDeBaja(String tipoDeBaja) {
		this.tipoDeBaja = tipoDeBaja;
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
	public Integer getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}
	
	
}