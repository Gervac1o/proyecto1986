package com.bew.demo.service;

import java.util.List;


import com.bew.demo.dto.ClienteDTO;
import com.bew.demo.exception.EmptyResultException;


public interface ClienteService {

	List<ClienteDTO> findAll();
	ClienteDTO findById(Integer idCliente);
	void saveCliente(ClienteDTO clienteDTO);
    void updateCliente(ClienteDTO clienteDTO)throws EmptyResultException;
    void deleteCliente(Integer idCliente) throws EmptyResultException;
    ClienteDTO ClienteNombre (String nombre);
     

}
