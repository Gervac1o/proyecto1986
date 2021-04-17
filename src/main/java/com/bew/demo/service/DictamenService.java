package com.bew.demo.service;

import java.util.List;

import com.bew.demo.dto.DictamenDTO;
import com.bew.demo.exception.EmptyResultException;

public interface DictamenService {

	List<DictamenDTO> findAll();
	DictamenDTO findById(Long idDictamen);
	void saveDictamen(DictamenDTO dictamenDTO);
	void updateDictamen(DictamenDTO dictamenDTO)throws EmptyResultException;
	void deleteDictamen(Long idDictamen)throws EmptyResultException;
	DictamenDTO findByIdAlumno(Long idAlumno);
	List<DictamenDTO> findByEstado(String estado);
	
}

