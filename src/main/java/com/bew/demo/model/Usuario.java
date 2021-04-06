package com.bew.demo.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column(name="email", unique = true)
	private String email;
	
	@Column(name="password")
	private String password;

	@Column(name="tipo_usuario")
	private Boolean tipoUsuario;
	
	@Column(name = "status")
	private Boolean status;
	
	public Usuario() {}
	public Usuario( Integer idUsuario, String email, String password, Boolean tipoUsuario, Boolean status) {
		 	
		this.idUsuario=idUsuario;
		this.email=email;
		this.password=password;
		this.tipoUsuario=tipoUsuario;
		this.status = status;
		
	}

	
}
