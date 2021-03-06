package com.bew.demo.service;

import org.springframework.core.io.ByteArrayResource;


import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import com.bew.demo.exception.EmptyResultException;


public interface FileImageService {
	
	ResponseEntity<ByteArrayResource> load(Integer fileId) throws EmptyResultException;
	//void store(MultipartFile file) throws EmptyResultException;
	void store(MultipartFile file, Integer idDictamen) throws EmptyResultException;
	
	
	
	
	
	

}
