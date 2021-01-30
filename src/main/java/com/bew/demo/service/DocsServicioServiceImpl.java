package com.bew.demo.service;

import javax.transaction.Transactional;

//import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bew.demo.dao.DocsServicioRepository;
import com.bew.demo.exception.EmptyResultException;
import com.bew.demo.model.DocsServicio;
import org.springframework.util.StringUtils;



@Service
@Transactional

public class DocsServicioServiceImpl implements DocsServicioService{
	@Autowired
	DocsServicioRepository docsServicioRepository;
	
	@Override
    public void store(MultipartFile file, Integer idServicio) throws EmptyResultException    {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try  {DocsServicio dbFile = new DocsServicio( fileName, file.getContentType(), file.getBytes(), idServicio);
		docsServicioRepository.save(dbFile);

		  }
		catch(Exception e) {
			e.printStackTrace();
			}
}



	@Override
	public ResponseEntity<ByteArrayResource> load(Integer idFile) throws EmptyResultException {
		DocsServicio file = docsServicioRepository.findById(idFile).orElseThrow(() -> new   EmptyResultException("File not found with id " + idFile));
	

        return  ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(file.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFileName() + "\"")
                .body(new ByteArrayResource(file.getData()));
	}
	
}