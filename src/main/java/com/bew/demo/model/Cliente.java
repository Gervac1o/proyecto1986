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
@Table(name="cliente")
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "cliente_sec", sequenceName = "cliente_seq", allocationSize = 1, initialValue=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_sec")
	@Column(name="id_cliente")
	private Integer idCliente;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name = "status")
	private Boolean status;
	
	
	
   /* @OneToOne(orphanRemoval = true, mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private DatosCliente datosCliente;

	public Cliente(DatosCliente datosCliente) {
		super();
		this.datosCliente = datosCliente;
	}
	*/


	public Cliente() {}
	public Cliente( Integer idCliente, String nombre, Boolean status) {
		
		
		this.nombre=nombre;	
		this.idCliente=idCliente;
		this.status = status;
}
    
	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}




	
	

}
