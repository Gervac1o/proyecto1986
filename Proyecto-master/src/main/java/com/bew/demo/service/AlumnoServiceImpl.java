package com.bew.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bew.demo.dao.AlumnoRepository;
import com.bew.demo.dto.AlumnoDTO;
import com.bew.demo.exception.EmptyResultException;
import com.bew.demo.model.Alumno;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

@Service
@Transactional
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	AlumnoRepository alumnoRepository;
	
	@Override
	public List<AlumnoDTO> findAll() {
		
		List<AlumnoDTO> alumnoDTO;
		List<Alumno> alumnos = alumnoRepository.findAll();
		alumnoDTO = new ArrayList<>();
		for(Alumno alumno: alumnos) {
			Mapper mapper = DozerBeanMapperBuilder.buildDefault();
			alumnoDTO.add(mapper.map(alumno, AlumnoDTO.class));
		}
		// TODO Auto-generated method stub
		return alumnoDTO;
	}

	@Override
	public AlumnoDTO findById(Integer idAlumno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveAlumno(AlumnoDTO alumnoDTO) {
		// TODO Auto-generated method stub
		Alumno alumno;
		Mapper mapper = DozerBeanMapperBuilder.buildDefault();
		alumno = (mapper.map(alumnoDTO, Alumno.class));
    	alumnoRepository.save(alumno);
	}

	@Override
	public void updateAlumno(AlumnoDTO alumnoDTO) throws EmptyResultException {
		// TODO Auto-generated method stub
		Alumno alumno;
		Mapper mapper = DozerBeanMapperBuilder.buildDefault();
		alumno = (mapper.map(alumnoDTO, Alumno.class));
		alumnoRepository.save(alumno);
	}

	@Override
	public void deleteAlumno(Integer idAlumno) throws EmptyResultException {
		// TODO Auto-generated method stub
		alumnoRepository.deleteById(idAlumno);
	}
	
	

}