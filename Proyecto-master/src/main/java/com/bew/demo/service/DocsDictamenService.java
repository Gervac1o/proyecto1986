package com.bew.demo.service;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.bew.demo.exception.EmptyResultException;

public interface DocsDictamenService {
	
	ResponseEntity<ByteArrayResource> load(Integer fileId) throws EmptyResultException;
<<<<<<< HEAD
	void store(MultipartFile file, Integer idDictamen) throws EmptyResultException;
=======
	void store(MultipartFile file) throws EmptyResultException;
>>>>>>> 040db90 (no message)

}
