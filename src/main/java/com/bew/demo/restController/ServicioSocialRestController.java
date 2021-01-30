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

import com.bew.demo.dto.ServicioSocialDTO;
import com.bew.demo.exception.EmptyResultException;
import com.bew.demo.service.ServicioSocialService;
@RestController
@RequestMapping("/servicioSocial")
@CrossOrigin("*")
public class ServicioSocialRestController {
	
	@Autowired
	ServicioSocialService servicioService;
	
	@GetMapping(path = "/findAll", produces = "application/json")
	public ResponseEntity<?> buscar(){
		List<ServicioSocialDTO> servicios;
		servicios = servicioService.findAll();
		return ResponseEntity.ok(servicios);
	}
	@PostMapping(path = "/save", consumes = "application/json")
	public ResponseEntity<?> save(@RequestBody ServicioSocialDTO servicioDTO){
	servicioService.saveServicioSocial (servicioDTO);
	return ResponseEntity.ok().build();
}
	@PatchMapping(path = "/update", consumes = "application/json")
	public ResponseEntity<?> update(@RequestBody ServicioSocialDTO servicioDTO)throws EmptyResultException{
	servicioService.updateServicioSocial(servicioDTO);
	return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(path = "/delete/{idServicio}", consumes="application/json")
	public ResponseEntity<?> delete(@PathVariable("idServicio") Integer idServicio) throws EmptyResultException{
	servicioService.deleteServicioSocial(idServicio);
	return ResponseEntity.ok().build();
	}
}