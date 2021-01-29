package com.bew.demo.service;

import java.util.List;

import com.bew.demo.dto.DictamenDTO;
import com.bew.demo.exception.EmptyResultException;

public interface DictamenService {

	List<DictamenDTO> findAll();
	DictamenDTO findById(Integer idDictamen);
	void saveDictamen(DictamenDTO dictamenDTO);
	void updateDictamen(DictamenDTO dictamenDTO)throws EmptyResultException;
	void deleteDictamen(Integer idDictamen)throws EmptyResultException;
	
}

