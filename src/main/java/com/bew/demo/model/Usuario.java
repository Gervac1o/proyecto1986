package com.bew.demo.model;

import java.io.Serializable;
//import java.util.List;
//import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="usuario")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "usuario_sec", sequenceName = "usuario_seq", allocationSize = 1, initialValue=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_sec")
	@Column(name="id_usuario")
	private Integer idUsuario;
	
	@Column(name="email")
	private String email;
	
	@Column(name="contraseña")
	private String contraseña;

	@Column(name="tipo_usuario")
	private Boolean tipoUsuario;
	
	@Column(name = "status")
	private Boolean status;
	
	public Usuario() {}
	public Usuario( Integer idUsuario, String email, String contraseña, Boolean tipoUsuario, Boolean status) {
		 	
		this.idUsuario=idUsuario;
		this.email=email;
		this.contraseña=contraseña;
		this.tipoUsuario=tipoUsuario;
		this.status = status;
		
	}

    
	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContraseña() {
		return contraseña;
	}
	
	public void setContraseña(String contraseña) {
		this.contraseña= contraseña;
	}
	
	public Boolean getTipoUsuario() {
		return tipoUsuario;
	}
	
	public void setTipoUsuario(Boolean tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
}
