package com.bew.demo.service;

import java.util.Optional;

import org.springframework.core.io.ByteArrayResource;


import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import com.bew.demo.exception.EmptyResultException;
import com.bew.demo.model.FileImage;
import com.bew.demo.dto.ListaDocsDTO;


public interface FileImageService {
	
	ResponseEntity<ByteArrayResource> load(Integer fileId) throws EmptyResultException;
	//void store(MultipartFile file) throws EmptyResultException;
	void store(MultipartFile file, Integer idDictamen) throws EmptyResultException;
	
	
	
	
	
	

}
