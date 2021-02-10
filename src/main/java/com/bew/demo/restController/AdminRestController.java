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

import com.bew.demo.dto.AdminDTO;
import com.bew.demo.exception.EmptyResultException;
import com.bew.demo.service.AdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminRestController {
	
	@Autowired
	AdminService adminService;
	
	@GetMapping(path = "/findAll", produces = "application/json")
	public ResponseEntity<?> buscar(){
		List<AdminDTO> admins;
		admins = adminService.findAll();
		return ResponseEntity.ok(admins);
	}
	@GetMapping(path = "/find/{idAdmin}", produces = "application/json")
	public ResponseEntity<?>find(@PathVariable("idAdmin") Integer idAdmin){
		AdminDTO adminDTO;
		adminDTO = adminService.findById(idAdmin);
		return ResponseEntity.ok(adminDTO);		
	}
	@GetMapping(path = "/findNombre/{nombre}", produces = "application/json")
	public ResponseEntity<?>findN(@PathVariable("nombre") String nombre){
		AdminDTO adminDTO;
		adminDTO = adminService.AdminNombre(nombre);
		
		return ResponseEntity.ok(adminDTO);
	}
	@GetMapping(path = "/findApellidos/{apellidos}", produces = "application/json")
	public ResponseEntity<?>findA(@PathVariable("apellidos") String apellidos){
		AdminDTO adminDTO;
		adminDTO = adminService.AdminApellidos(apellidos);
		
		return ResponseEntity.ok(adminDTO);
	}
	@GetMapping(path = "/findTelefono/{telefono}", produces = "application/json")
	public ResponseEntity<?>findT(@PathVariable("telefono") Integer telefono){
		AdminDTO adminDTO;
		adminDTO = adminService.AdminTelefono(telefono);
		
		return ResponseEntity.ok(adminDTO);
	}
	@GetMapping(path = "/findIdUsuario/{idUsuario}", produces = "application/json")
	public ResponseEntity<?>findIdUsuario(@PathVariable("idUsuario") Integer idUsuario){
		AdminDTO adminDTO;
		System.out.println(idUsuario);
		adminDTO = adminService.findByIdUsuario(idUsuario);
		return ResponseEntity.ok(adminDTO);		
	}
	@PostMapping(path = "/save", consumes = "application/json")
	public ResponseEntity<?> save(@RequestBody AdminDTO adminDTO){
	adminService.saveAdmin (adminDTO);
	return ResponseEntity.ok().build();
	}
	@PatchMapping(path = "/update", consumes = "application/json")
	public ResponseEntity<?> update(@RequestBody AdminDTO adminDTO)throws EmptyResultException{
	adminService.updateAdmin(adminDTO);
	return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(path = "/delete/{idAdmin}", consumes="application/json")
	public ResponseEntity<?> delete(@PathVariable("idAdmin") Integer idAdmin) throws EmptyResultException{
	adminService.deleteAdmin(idAdmin);
	return ResponseEntity.ok().build();
	}
}