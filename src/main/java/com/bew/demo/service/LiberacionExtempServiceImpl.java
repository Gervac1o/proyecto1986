package com.bew.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bew.demo.dao.LiberacionExtempRepository;
import com.bew.demo.dto.LiberacionExtempDTO;
import com.bew.demo.exception.EmptyResultException;
import com.bew.demo.model.LiberacionExtemp;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

@Service
@Transactional
public class LiberacionExtempServiceImpl implements LiberacionExtempService {

	@Autowired
	LiberacionExtempRepository liberacionRepository;
	
	@Override
	public List<LiberacionExtempDTO> findAll(){
		List<LiberacionExtempDTO> liberacionDTO;
		List<LiberacionExtemp> liberaciones = liberacionRepository.findAll();
		liberacionDTO = new ArrayList<>();
		for(LiberacionExtemp liberacion: liberaciones) {
			Mapper mapper = DozerBeanMapperBuilder.buildDefault();
			liberacionDTO.add(mapper.map(liberacion, LiberacionExtempDTO.class));
		}
		// TODO Auto-generated method stub
		return liberacionDTO;
	}

	@Override
	public LiberacionExtempDTO findById(Integer idLiberacion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveLiberacionExtemp(LiberacionExtempDTO liberacionDTO) {
		// TODO Auto-generated method stub
		LiberacionExtemp liberacion;
		Mapper mapper = DozerBeanMapperBuilder.buildDefault();
		liberacion = (mapper.map(liberacionDTO, LiberacionExtemp.class));
    	liberacionRepository.save(liberacion);
	}

	@Override
	public void updateLiberacionExtemp(LiberacionExtempDTO liberacionDTO) throws EmptyResultException {
		// TODO Auto-generated method stub
		LiberacionExtemp liberacion;
		Mapper mapper = DozerBeanMapperBuilder.buildDefault();
		liberacion = (mapper.map(liberacionDTO, LiberacionExtemp.class));
		liberacionRepository.save(liberacion);
	}

	@Override
	public void deleteLiberacionExtemp(Integer idLiberacion) throws EmptyResultException {
		// TODO Auto-generated method stub
		liberacionRepository.deleteById(idLiberacion);
	}

}
