package com.bew.demo.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bew.demo.exception.EmptyResultException;
import com.bew.demo.service.DocsDictamenService;

@RestController
@RequestMapping("/docDictamen")
@CrossOrigin("*")

public class DocsDictamenRestController {

	@Autowired
	DocsDictamenService docsDictamenService;
	

    @PostMapping(path = "/upload/{idDictamen}")
    public void FileUpload(@RequestParam("file") MultipartFile file, @PathVariable Integer idDictamen)  throws EmptyResultException {

    	docsDictamenService.store(file,idDictamen);
}

    
    
    @GetMapping("/getFile/{idFile}")
    @ResponseBody
    public ResponseEntity<ByteArrayResource> serveFile(@PathVariable Integer idFile) throws EmptyResultException {

   	
        return  docsDictamenService.load(idFile);
    }
}
