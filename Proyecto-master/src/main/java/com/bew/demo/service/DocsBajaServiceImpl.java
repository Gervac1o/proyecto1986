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

import com.bew.demo.dao.DocsBajaRepository;
import com.bew.demo.exception.EmptyResultException;
import com.bew.demo.model.DocsBaja;
@Service
@Transactional
public class DocsBajaServiceImpl implements DocsBajaService {

	@Autowired
	DocsBajaRepository docsBajaRepository;
	
	@Override
    public void store(MultipartFile file) throws EmptyResultException    {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try  {DocsBaja dbFile = new DocsBaja( fileName, file.getContentType(), file.getBytes(), null);
		docsBajaRepository.save(dbFile);

		  }
		catch(Exception e) {
			e.printStackTrace();
			}
}



	@Override
	public ResponseEntity<ByteArrayResource> load(Integer idFile) throws EmptyResultException {
		DocsBaja file = docsBajaRepository.findById(idFile).orElseThrow(() -> new   EmptyResultException("File not found with id " + idFile));
	

        return  ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(file.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFileName() + "\"")
                .body(new ByteArrayResource(file.getData()));
        
        
    
    }

}
