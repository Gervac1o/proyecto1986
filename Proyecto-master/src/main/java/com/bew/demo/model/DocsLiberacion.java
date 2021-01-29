package com.bew.demo.model;

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

@Entity
@Table(name = "docs_liberacion")
public class DocsLiberacion implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "doc_sec", sequenceName = "doc_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doc_sec")
	private Integer fileId;  
	
    @Column(name = "file_name")
    private String fileName;

    @Column(name = "type")
    private String fileType;
    
    @Lob
    private byte[] data;
    
    @Column(name = "id_liberacion")
    private Integer idLiberacion;


    public DocsLiberacion() {}
    
    public DocsLiberacion (String fileName, String fileType, byte[] data, Integer idLiberacion) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
      this.idLiberacion=idLiberacion;
    }
    
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_liberacion",insertable=false, updatable = false)
	private LiberacionExtemp liberacionExtemp;

	public Integer getIdLiberacion() {
		return idLiberacion;
	}

	public void setIdLiberacion(Integer idLiberacion) {
		this.idLiberacion = idLiberacion;
	}

	public Integer getFileId() {
		return fileId;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
    


}
