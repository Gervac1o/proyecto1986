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

import com.bew.demo.dto.ListaDocsDTO;
import com.bew.demo.service.ListaDocsService;

@RestController
@RequestMapping("/lista")
@CrossOrigin("*")
public class ListaDocsRestController {
	@Autowired
	ListaDocsService listaDocsService; 

	@GetMapping(path = "/findAll", produces = "application/json")
	public ResponseEntity<?> findAll(){
		List<ListaDocsDTO> listaDocs;
		listaDocs = listaDocsService.findAll();
		
		return ResponseEntity.ok(listaDocs);
	}
	
	@GetMapping(path = "/find/{idLista}", produces = "application/json")
	public ResponseEntity<?>find(@PathVariable("idCliente") Integer idLista){
		ListaDocsDTO listaDocsDTO;
		listaDocsDTO = listaDocsService.findById(idLista);
		return ResponseEntity.ok(listaDocsDTO);		
	}
	
	@PostMapping(path = "/save", consumes = "application/json")
	public ResponseEntity<?> save(@RequestBody ListaDocsDTO listaDocsDTO){
		listaDocsService.saveListaDocs (listaDocsDTO);

		   return ResponseEntity.ok().build();	
	}
	
	@PatchMapping(path = "/update", consumes = "application/json")
	public ResponseEntity<?> update(@RequestBody ListaDocsDTO listaDocsDTO){
		listaDocsService.updateListaDocs(listaDocsDTO);
	return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(path="/delete/{idLista}", consumes="application/json")
	public ResponseEntity<?> delete(@PathVariable("idLista") Integer idLista) {
		listaDocsService.deleteListaDocs(idLista);
		return ResponseEntity.ok().build();
	}	
}