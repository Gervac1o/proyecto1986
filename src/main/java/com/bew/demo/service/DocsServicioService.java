package com.bew.demo.service;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import com.bew.demo.exception.EmptyResultException;
//import com.bew.demo.model.DocsServicio;

public interface DocsServicioService {

	ResponseEntity<ByteArrayResource> load(Integer fileId) throws EmptyResultException;
	void store(MultipartFile file, Integer idServicio) throws EmptyResultException;
}
