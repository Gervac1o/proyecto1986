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

import com.bew.demo.dto.SolicitudBajaDTO;
import com.bew.demo.exception.EmptyResultException;
import com.bew.demo.service.SolicitudBajaService;
@RestController
@RequestMapping("/solicitudBaja")
@CrossOrigin("*")
public class SolicitudBajaRestController {
	
	@Autowired
	SolicitudBajaService solicitudService;
	
	@GetMapping(path = "/findAll", produces = "application/json")
	public ResponseEntity<?> buscar(){
		List<SolicitudBajaDTO> solicitudes;
		solicitudes = solicitudService.findAll();
		return ResponseEntity.ok(solicitudes);
	}
	@GetMapping(path = "/find/{idSolicitud}", produces = "application/json")
	public ResponseEntity<?>find(@PathVariable("idSolicitud") Integer idSolicitud){
	SolicitudBajaDTO solicitudDTO;
	solicitudDTO = solicitudService.findById(idSolicitud);
	return ResponseEntity.ok(solicitudDTO);		
	}
	@GetMapping(path = "/findIdAlumno/{idAlumno}", produces = "application/json")
	public ResponseEntity<?>findByIdAlumno(@PathVariable("idAlumno") Integer idAlumno){
	SolicitudBajaDTO solicitudDTO;
	solicitudDTO = solicitudService.findByIdAlumno(idAlumno);
	return ResponseEntity.ok(solicitudDTO);		
	}
	@GetMapping(path = "/findEstado/{estado}", produces = "application/json")
	public ResponseEntity<?>findEstado(@PathVariable("estado") String estado){
		List<SolicitudBajaDTO> solicitudDTO;
		solicitudDTO = solicitudService.findByEstado(estado);
		
		return ResponseEntity.ok(solicitudDTO);
	}
	@PostMapping(path = "/save", consumes = "application/json")
	public ResponseEntity<?> save(@RequestBody SolicitudBajaDTO solicitudDTO){
	solicitudService.saveSolicitudBaja (solicitudDTO);
	return ResponseEntity.ok().build();
	}
	@PatchMapping(path = "/update", consumes = "application/json")
	public ResponseEntity<?> update(@RequestBody SolicitudBajaDTO solicitudDTO)throws EmptyResultException{
	solicitudService.updateSolicitudBaja(solicitudDTO);
	return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(path = "/delete/{idSolicitud}")
	public ResponseEntity<?> delete(@PathVariable("idSolicitud") Integer idSolicitud) throws EmptyResultException{
	solicitudService.deleteSolicitudBaja(idSolicitud);
	return ResponseEntity.ok().build();
	}
}