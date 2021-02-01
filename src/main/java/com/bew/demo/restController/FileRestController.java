package com.bew.demo.restController;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bew.demo.exception.EmptyResultException;
import com.bew.demo.service.FileImageService;

@RestController
@RequestMapping("/file")
@CrossOrigin("*")
public class FileRestController {
	@Autowired
	FileImageService fileService;
	
    @PostMapping(path = "/upload")
    public void FileUpload(@RequestParam("file") MultipartFile file)  throws EmptyResultException {

    	fileService.store(file );

       // return ResponseEntity.ok().build();
    }
    
    @GetMapping("/getFile/{idFile}")
    @ResponseBody
    public ResponseEntity<ByteArrayResource> serveFile(@PathVariable Integer idFile) throws EmptyResultException {
        return  fileService.load(idFile);
    }
    

    	

}
