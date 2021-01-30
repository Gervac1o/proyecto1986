package com.bew.demo.service;




import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.bew.demo.dao.DocsDictamenRepository;

import com.bew.demo.exception.EmptyResultException;
import com.bew.demo.model.DocsDictamen;


@Service
@Transactional
public class DocsDictamenServiceImpl implements DocsDictamenService {

	@Autowired
	DocsDictamenRepository docsDictamenRepository;
	
	@Override
<<<<<<< HEAD
<<<<<<< HEAD
    public void store(MultipartFile file, Integer idDictamen) throws EmptyResultException    {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try  {DocsDictamen dbFile = new DocsDictamen( fileName, file.getContentType(), file.getBytes(), idDictamen);
=======
    public void store(MultipartFile file) throws EmptyResultException    {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try  {DocsDictamen dbFile = new DocsDictamen( fileName, file.getContentType(), file.getBytes(), null);
>>>>>>> 040db90 (no message)
=======
    public void store(MultipartFile file, Integer idDictamen) throws EmptyResultException    {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try  {DocsDictamen dbFile = new DocsDictamen( fileName, file.getContentType(), file.getBytes(), idDictamen);
>>>>>>> dc9fa98 (se termino los seervicios rest para subir documentos)
		docsDictamenRepository.save(dbFile);

		  }
		catch(Exception e) {
			e.printStackTrace();
			}
}



	@Override
	public ResponseEntity<ByteArrayResource> load(Integer idFile) throws EmptyResultException {
		DocsDictamen file = docsDictamenRepository.findById(idFile).orElseThrow(() -> new   EmptyResultException("File not found with id " + idFile));
	

        return  ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(file.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFileName() + "\"")
                .body(new ByteArrayResource(file.getData()));
        
        
    
    }

}
