package com.bew.demo.model;



import lombok.Data;

import javax.persistence.Column;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "file")

public class FileImage  {

	@Id
	@SequenceGenerator(name = "file_sec", sequenceName = "file_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "file_sec")
	private Long fileId;
	
    @Column(name = "file_name")
    private String fileName;

    @Column(name = "type")
    private String fileType;
    
    @Lob
    private byte[] data;
    
    
    @Column(name = "id_dictamen")
    private Integer idDictamen;



	public FileImage() {}
    
    public FileImage (String fileName, String fileType, byte[] data, Integer idDictamen) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
       this.idDictamen=idDictamen;
        
    }
	
}

