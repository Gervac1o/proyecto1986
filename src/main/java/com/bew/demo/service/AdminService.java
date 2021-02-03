package com.bew.demo.service;

import java.util.List;
import com.bew.demo.dto.AdminDTO;
import com.bew.demo.exception.EmptyResultException;

public interface AdminService {
	List<AdminDTO> findAll();
	AdminDTO findById(Integer idAdmin);
	void saveAdmin(AdminDTO adminDTO);
	void updateAdmin(AdminDTO adminDTO)throws EmptyResultException;
	void deleteAdmin(Integer idAdmin)throws EmptyResultException;
	AdminDTO AdminNombre (String nombre);
	AdminDTO AdminApellidos (String apellidos);
	AdminDTO AdminTelefono (Integer telefono);
}
