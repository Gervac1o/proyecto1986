package com.bew.demo.model;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "docs_servicio")
public class DocsServicio implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "doc_sec", sequenceName = "doc_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doc_sec")
	private Long fileId;
	
    @Column(name = "file_name")
    private String fileName;

    @Column(name = "type")
    private String fileType;
    
    @Lob
    private byte[] data;

    @Column(name = "id_doc")
    private String idDoc;
    
    public DocsServicio() {}
    
    public DocsServicio (String fileName, String fileType, byte[] data, String idDoc) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
        this.idDoc= idDoc;
        //this.fileId = fileId;
    }
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_servicio",insertable=false, updatable = false)
	private ServicioSocial servicio;


}