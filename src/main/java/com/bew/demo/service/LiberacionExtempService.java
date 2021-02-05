package com.bew.demo.service;
import java.util.List;
import com.bew.demo.dto.LiberacionExtempDTO;
import com.bew.demo.exception.EmptyResultException;

public interface LiberacionExtempService {
	List<LiberacionExtempDTO> findAll();
	LiberacionExtempDTO findById(Integer idLiberacion);
	void saveLiberacionExtemp(LiberacionExtempDTO liberacionDTO);
	void updateLiberacionExtemp(LiberacionExtempDTO liberacionDTO)throws EmptyResultException;
	void deleteLiberacionExtemp(Integer idLiberacion)throws EmptyResultException;
	LiberacionExtempDTO findByIdAlumno(Integer idAlumno);
}