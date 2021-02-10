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
@Table(name="servicio_social")
public class ServicioSocial implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "servicio_sec", sequenceName = "servicio_seq", allocationSize = 1, initialValue=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "servicio_sec")
	@Column(name="id_servicio")
	private Integer idServicio;

	@Column(name="semestre")
	private Integer semestre;

	@Column(name="responsable_directo")
	private String responsableDirecto;
	
	@Column(name="id_alumno")
	private Integer idAlumno;

	public ServicioSocial() {}
	public ServicioSocial( Integer idServicio, Integer semestre, String responsableDirecto, Integer idAlumno) {

		this.idServicio=idServicio;
		this.semestre=semestre;
		this.responsableDirecto=responsableDirecto;
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
