package com.bew.demo.model;

import java.io.Serializable;
//import java.sql.Date;
//import java.util.Date;

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
@Table(name="liberacion_extemporanea")
public class LiberacionExtemp implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_liberacion")
	private Integer idLiberacion;

	@Column(name="semestre")
	private String semestre;

	@Column(name="egresado")
	private Boolean egresado;

	@Column(name="registro_ss")
	private String registroSS;
	
	@Column(name="prestatario")
	private String prestatario;

	@Column(name="programa_ss")
	private String programaSS;

	@Column(name="fecha_inicio")
	private String fechaInicio;

	@Column(name="fecha_termino")
	private String fechaTermino;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="estado")
	private String estado;
	
	@Column(name="fecha_registro")
	private String fechaRegistro;
	
	@Column(name="revisado")
	private String revisado;

	@Column(name="id_alumno")
	private Integer idAlumno;

	public LiberacionExtemp() {}
	public LiberacionExtemp( Integer idLiberacion, String semestre, Boolean egresado, String registroSS, 
	String prestatario, String programaSS, String fechaInicio, String fechaTermino, String telefono,
	String fechaRegistro, String revisado, String estado, Integer idAlumno) {
	

		this.idLiberacion=idLiberacion;
		this.semestre=semestre;
		this.egresado=egresado;
		this.registroSS=registroSS;
		this.prestatario=prestatario;
		this.programaSS=programaSS;
		this.fechaInicio=fechaInicio;
		this.fechaTermino=fechaTermino;
		this.telefono=telefono;
		this.estado=estado;
		this.fechaRegistro=fechaRegistro;
		this.revisado=revisado;
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
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
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
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaTermino() {
		return fechaTermino;
	}
	public void setFechaTermino(String fechaTermino) {
		this.fechaTermino = fechaTermino;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
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
