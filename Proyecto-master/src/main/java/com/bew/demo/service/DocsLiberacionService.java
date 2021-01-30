package com.bew.demo.service;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.bew.demo.exception.EmptyResultException;

public interface DocsLiberacionService {

	ResponseEntity<ByteArrayResource> load(Integer fileId) throws EmptyResultException;
<<<<<<< HEAD
<<<<<<< HEAD
	void store(MultipartFile file, Integer idLiberacion) throws EmptyResultException;
=======
	void store(MultipartFile file) throws EmptyResultException;
>>>>>>> 040db90 (no message)
=======
	void store(MultipartFile file, Integer idLiberacion) throws EmptyResultException;
>>>>>>> dc9fa98 (se termino los seervicios rest para subir documentos)
}
