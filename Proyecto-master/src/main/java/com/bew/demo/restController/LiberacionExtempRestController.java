package com.bew.demo.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bew.demo.dto.LiberacionExtempDTO;
import com.bew.demo.exception.EmptyResultException;
import com.bew.demo.service.LiberacionExtempService;
@RestController
@RequestMapping("/liberacionExtemporanea")
@CrossOrigin("*")
public class LiberacionExtempRestController {
	
	@Autowired
	LiberacionExtempService liberacionService;
	
	@GetMapping(path = "/findAll", produces = "application/json")
	public ResponseEntity<?> buscar(){
		List<LiberacionExtempDTO> liberaciones;
		liberaciones = liberacionService.findAll();
		return ResponseEntity.ok(liberaciones);
	}
	@PostMapping(path = "/save", consumes = "application/json")
	public ResponseEntity<?> save(@RequestBody LiberacionExtempDTO liberacionDTO){
	liberacionService.saveLiberacionExtemp (liberacionDTO);
	return ResponseEntity.ok().build();
}
	@PatchMapping(path = "/update", consumes = "application/json")
	public ResponseEntity<?> update(@RequestBody LiberacionExtempDTO liberacionDTO)throws EmptyResultException{
	liberacionService.updateLiberacionExtemp(liberacionDTO);
	return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(path = "/delete/{idLiberacion}", consumes="application/json")
	public ResponseEntity<?> delete(@PathVariable("idLiberacion") Integer idLiberacion) throws EmptyResultException{
	liberacionService.deleteLiberacionExtemp(idLiberacion);
	return ResponseEntity.ok().build();
	}
}