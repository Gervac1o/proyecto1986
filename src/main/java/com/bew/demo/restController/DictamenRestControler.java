package com.bew.demo.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bew.demo.dto.DictamenDTO;
import com.bew.demo.exception.EmptyResultException;
import com.bew.demo.service.DictamenService;

@RestController
@RequestMapping("/dictamen")
@CrossOrigin("*")
public class DictamenRestControler {
	
	@Autowired
	DictamenService dictamenService;
	
	@GetMapping(path = "/findAll", produces = "application/json")
	public ResponseEntity<?> findAll(){
		List<DictamenDTO> dictamen;
		dictamen = dictamenService.findAll();
		return ResponseEntity.ok(dictamen);
	}
	@GetMapping(path = "/find/{idDictamen}", produces = "application/json")
	public ResponseEntity<?>find(@PathVariable("idDictamen") Integer idDictamen){
		DictamenDTO dictamenDTO;
		dictamenDTO = dictamenService.findById(idDictamen);
		return ResponseEntity.ok(dictamenDTO);		
	}
	@GetMapping(path = "/findIdAlumno/{idAlumno}", produces = "application/json")
	public ResponseEntity<?>findByIdAlumno(@PathVariable("idAlumno") Integer idAlumno){
		DictamenDTO dictamenDTO;
		dictamenDTO = dictamenService.findByIdAlumno(idAlumno);
		return ResponseEntity.ok(dictamenDTO);
	}
	@PostMapping(path = "/save", consumes = "application/json")
	public ResponseEntity<?> save(@RequestBody DictamenDTO dictamenDTO){
		dictamenService.saveDictamen (dictamenDTO);
	return ResponseEntity.ok().build();
	}
	@PostMapping(path = "/update", consumes = "application/json")
	public ResponseEntity<?> update(@RequestBody DictamenDTO dictamenDTO)throws EmptyResultException{
		dictamenService.updateDictamen(dictamenDTO);
	return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(path = "/delete/{idDictamen}", consumes="application/json")
	public ResponseEntity<?> delete(@PathVariable("idDictamen") Integer idDictamen) throws EmptyResultException{
		dictamenService.deleteDictamen(idDictamen);
	return ResponseEntity.ok().build();
	}

}